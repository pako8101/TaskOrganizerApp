package com.taskOrganizerApp.model.dto.duty;

import java.util.ArrayList;
import java.util.List;

public class DutyHomeViewModel {
    private List<DutyDTO> assignedDuties;
    private List<DutyDTO>availableDuties;

    private int availableSize;

    public DutyHomeViewModel() {
       this(new ArrayList<>(), new ArrayList<>());
    }

    public DutyHomeViewModel(List<DutyDTO> assignedDuties, List<DutyDTO> availableDuties, int availableSize) {
        this.assignedDuties = assignedDuties;
        this.availableDuties = availableDuties;
        this.availableSize = availableDuties.size();
    }

    public <E> DutyHomeViewModel(List<E> es, List<E> es1) {

    }

    public List<DutyDTO> getAssignedDuties() {
        return assignedDuties;
    }

    public void setAssignedDuties(List<DutyDTO> assignedDuties) {
        this.assignedDuties = assignedDuties;
    }

    public List<DutyDTO> getAvailableDuties() {
        return availableDuties;
    }

    public void setAvailableDuties(List<DutyDTO> availableDuties) {
        this.availableDuties = availableDuties;
    }

    public int getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(int availableSize) {
        this.availableSize = availableSize;
    }
}
