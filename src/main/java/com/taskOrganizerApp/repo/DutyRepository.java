package com.taskOrganizerApp.repo;

import com.taskOrganizerApp.model.entity.Duty;

import com.taskOrganizerApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DutyRepository extends JpaRepository<Duty, Long> {
    List<Duty> findByAssignee(User user);
    @Query(nativeQuery = true, value = "select * from duties where assignee_id is null ")
    List<Duty> getAllAvailable();
}
