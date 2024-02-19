package com.taskOrganizerApp.service.impl;

import com.taskOrganizerApp.model.dto.duty.DutyAddBindingModel;
import com.taskOrganizerApp.model.dto.duty.DutyDTO;
import com.taskOrganizerApp.model.dto.duty.DutyHomeViewModel;
import com.taskOrganizerApp.model.entity.Duty;
import com.taskOrganizerApp.model.entity.Importance;
import com.taskOrganizerApp.model.entity.User;
import com.taskOrganizerApp.repo.DutyRepository;
import com.taskOrganizerApp.repo.ImportanceRepository;
import com.taskOrganizerApp.repo.UserRepository;
import com.taskOrganizerApp.service.DutyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DutiesServiceImpl implements DutyService {
    private final DutyRepository dutyRepository;
    private final ImportanceRepository importanceRepository;
    private final UserRepository userRepository;

    public DutiesServiceImpl(DutyRepository dutyRepository, ImportanceRepository importanceRepository, UserRepository userRepository) {
        this.dutyRepository = dutyRepository;
        this.importanceRepository = importanceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(DutyAddBindingModel dutyAddBindingModel) {
        Importance importance = this.importanceRepository.
                findByName(dutyAddBindingModel.getImportance());
        if (importance!= null){
            Duty duty = new Duty();
            duty.setDescription(dutyAddBindingModel.getDescription());
            duty.setDueDate(LocalDate.parse(dutyAddBindingModel.getDueDate()));
       this.dutyRepository.save(duty);
        }


    }

    @Override
    public void remove(Long id) {
this.dutyRepository.deleteById(id);
    }

    @Override
    public void assign(Long id, String username) {
        Optional<Duty>optionalDuty = dutyRepository.findById(id);
        if (optionalDuty.isPresent()){
            Duty duty = optionalDuty.get();
            if (username==null){
                duty.setAssignee(null);
            }else {
                User user = userRepository.findByUsername(username);
                duty.setAssignee(user);
            }
            dutyRepository.save(duty);
        }

    }

    @Override
    public DutyHomeViewModel getHomeViewData(String username) {
        User user = userRepository.findByUsername(username);

        List<DutyDTO> assignedDuties = dutyRepository.findByAssignee(user)
                .stream().map(DutyDTO::createFromDuty)
                .toList();

        List<DutyDTO> availableDuties = dutyRepository.getAllAvailable()
                .stream().map(DutyDTO::createFromDuty)
                .toList();

        return new DutyHomeViewModel(assignedDuties,availableDuties);
    }
}
