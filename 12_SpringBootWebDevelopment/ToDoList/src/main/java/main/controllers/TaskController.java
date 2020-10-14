package main.controllers;

import main.Storage;
import main.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @PostMapping("/tasks/")
    public int addTask(Task task) {
        return Storage.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deleteTask(@PathVariable int id)
    {
        Task task = Storage.getTask(id);
        if (task == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.deleteTask(id);
        return new ResponseEntity("Задача удалена id:" + id, HttpStatus.OK);
    }

    @PutMapping ("/tasks/{id}")
    public ResponseEntity updateTask(@PathVariable int id)
    {
        Task task = Storage.getTask(id);
        if (task == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.putTask(task);
        return new ResponseEntity("Задача обновлена id:" + id, HttpStatus.OK);
    }

    @GetMapping("/tasks/")
    public List<Task> getTasks() {
        return Storage.getAllTasks();
    }

    @DeleteMapping("/tasks/")
    public ResponseEntity deleteAllTasks() {
        Storage.deleteAllTask();
        return new ResponseEntity("Весь список задач удалён", HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity getTask(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if(task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }
}
