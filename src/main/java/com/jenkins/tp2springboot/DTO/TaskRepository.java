package com.jenkins.tp2springboot.DTO;

import com.jenkins.tp2springboot.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
