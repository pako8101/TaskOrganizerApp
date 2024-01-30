package com.taskOrganizerApp.model.entity;

import com.taskOrganizerApp.model.enums.ImportanceName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "importance")
public class Importance extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ImportanceName name;


    @Column(nullable = false)
    private String description;

    @OneToMany
    private Set<Duty> duties;

    private void setDescription(ImportanceName name) {
        String description = "";
        switch (name) {
            case URGENT -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT ->
                    description = "A core functionality that your product is explicitly supposed to perform is compromised.";
            case LOW -> description = "Should be fixed if time permits but can be postponed.";
        }
        this.description = description;
    }
}
