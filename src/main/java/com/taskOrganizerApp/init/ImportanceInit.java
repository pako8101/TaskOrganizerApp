package com.taskOrganizerApp.init;

import com.taskOrganizerApp.model.entity.Importance;
import com.taskOrganizerApp.model.enums.ImportanceName;
import com.taskOrganizerApp.repo.ImportanceRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImportanceInit implements CommandLineRunner {
    private final ImportanceRepository importanceRepository;

    public ImportanceInit(ImportanceRepository importanceRepository) {
        this.importanceRepository = importanceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long count = importanceRepository.count();

        if (count==0){
            List<Importance> importances = new ArrayList<>();
          Arrays.stream(ImportanceName.values())
                  .forEach(impName -> {
                      Importance importance = new Importance();
                      importance.setName(impName);
                      importances.add(importance);
                  });

          importanceRepository.saveAll(importances);
        }
    }
}
