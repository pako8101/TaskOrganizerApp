package com.taskOrganizerApp.model.dto.duty;

import com.taskOrganizerApp.model.entity.Duty;
import com.taskOrganizerApp.model.enums.ImportanceName;

public class DutyDTO {
    private Long id;
    private String description;
    private String dueDate;
    private ImportanceName importance;

    public ImportanceName getImportance() {
        return importance;
    }

    public void setImportance(ImportanceName importance) {
        this.importance = importance;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public static DutyDTO createFromDuty(Duty duty) {
        DutyDTO dutyDTO = new DutyDTO();

        dutyDTO.setId(duty.getId());
        dutyDTO.setDescription(duty.getDescription());
        dutyDTO.setDueDate(duty.getDueDate().toString());
        dutyDTO.setImportance(duty.getImportance().getName());


        return dutyDTO;
    }
}
