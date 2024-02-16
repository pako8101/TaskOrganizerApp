package com.taskOrganizerApp.model.dto.duty;

import com.taskOrganizerApp.model.annotation.DateInFuture;
import com.taskOrganizerApp.model.entity.Importance;
import com.taskOrganizerApp.model.enums.ImportanceName;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class DutyAddBindingModel {
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @DateInFuture(message = "Due Date must be in future")
    private LocalDate dueDate;


    @NotNull(message = "You must select a importance!")
    private ImportanceName importance;

    public DutyAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ImportanceName getImportance() {
        return importance;
    }

    public void setImportance(ImportanceName importance) {
        this.importance = importance;
    }
}
