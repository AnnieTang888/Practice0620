package com.example.demo.controller;

import com.example.demo.domain.Task;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private Map<Integer, Task> taskMap = new HashMap<>();
    private int idCounter = 1;

    @GetMapping
    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        task.setId(idCounter++);
        task.setStatus("PENDING");
        taskMap.put(task.getId(), task);
        return task;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskMap.get(id);
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable int id, @RequestParam String status) {
        Task task = taskMap.get(id);
        if (task != null) {
            task.setStatus(status.toUpperCase());
        }
        return task;
    }
    @DeleteMapping("/{id}")
    public String deleteTaskByID(@PathVariable int id){
    	Task removed = taskMap.remove(id);
    	if(removed != null) {
    		return "Task with ID " + id + " was deleted :(";
    	}else {
    		return "Task with ID " + id + " not found!";
    	}
    }
}

	

