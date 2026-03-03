package com.example.taskflow_api.service;

import com.example.taskflow_api.entity.Task;
import com.example.taskflow_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public Task create(Task task) {
        if (task.getStatus() == null || task.getStatus().isBlank()) {
            task.setStatus("TODO");
        }
        return repo.save(task);
    }

    public List<Task> getAll() {
        return repo.findAll();
    }
}
