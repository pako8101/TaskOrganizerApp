package com.taskOrganizerApp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "duties")
public class Duty extends BaseEntity{
    @Length(min = 2,max = 50)
    @Column(nullable = false)
    private String description;

    @Future
    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne
   @NotNull
    private Importance importance;

    @ManyToOne
    private User assignee;

}
