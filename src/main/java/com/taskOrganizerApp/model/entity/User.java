package com.taskOrganizerApp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String username;

    @Length(min = 3, max = 20)
    @Column(unique = true, nullable = false)
    private String password;
    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "assignee")
    private Set<Duty> duties;
}
