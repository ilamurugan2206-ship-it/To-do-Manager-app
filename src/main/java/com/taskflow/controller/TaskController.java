
package com.taskflow.controller;

import com.taskflow.entity.Task;
import com.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@Valid @RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @Valid @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/{id}/toggle")
    public Task toggleTaskStatus(@PathVariable Long id) {
        return taskService.toggleTaskStatus(id);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(
            @PathVariable Task.Priority priority) {
        return taskService.getTasksByPriority(priority);
    }

    @GetMapping("/status/{completed}")
    public List<Task> getTasksByStatus(
            @PathVariable boolean completed) {
        return taskService.getTasksByStatus(completed);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
