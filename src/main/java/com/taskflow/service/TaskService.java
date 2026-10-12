
package com.taskflow.service;

import com.taskflow.entity.Task;
import com.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found with ID: " + id));
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setPriority(updatedTask.getPriority());
        task.setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
    }

    public Task toggleTaskStatus(Long id) {
        Task task = getTaskById(id);
        task.setCompleted(!task.isCompleted());

        return taskRepository.save(task);
    }

    public List<Task> getTasksByPriority(Task.Priority priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }
}
