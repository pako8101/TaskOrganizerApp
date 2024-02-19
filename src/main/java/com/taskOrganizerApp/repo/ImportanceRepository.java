package com.taskOrganizerApp.repo;

import com.taskOrganizerApp.model.entity.Importance;
import com.taskOrganizerApp.model.enums.ImportanceName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportanceRepository extends JpaRepository<Importance, Long> {
    Importance findByName(ImportanceName importance);
}
