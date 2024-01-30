package com.taskOrganizerApp.repo;

import com.taskOrganizerApp.model.entity.Duty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DutyRepository extends JpaRepository<Duty, Long> {
}
