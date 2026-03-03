package com.example.taskflow_api.controller;

import com.example.taskflow_api.dto.CreateTaskRequest;
import com.example.taskflow_api.entity.Task;
import com.example.taskflow_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@Valid @RequestBody CreateTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        return service.create(task);
    }

    @GetMapping
    public List<Task> all() {
        return service.getAll();
    }
}
