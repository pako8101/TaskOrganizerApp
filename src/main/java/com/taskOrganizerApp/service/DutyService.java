package com.taskOrganizerApp.service;


import com.taskOrganizerApp.model.dto.duty.DutyAddBindingModel;
import com.taskOrganizerApp.model.dto.duty.DutyHomeViewModel;

public interface DutyService {

    void add(DutyAddBindingModel dutyAddBindingModel);

    void remove(Long id);

    void assign(Long id, String username);

    DutyHomeViewModel getHomeViewData(String username);
}
