/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.controller;


import com.kanban.dto.Mensaje;
import com.kanban.model.Task;
import com.kanban.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author yonder
 */
@RestController
@CrossOrigin(origins={"*"})
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    //listar
    @GetMapping("/tasks")
    public List<Task> listAll()
    {
        return taskService.listTasks();
    }
    
     @GetMapping("/tasks/user/{id_user}")
    public List<Task> TaskByUser(@PathVariable Long id_user)
    {
        return taskService.TasksByUser(id_user);
    }
    
    //guardar
    @PostMapping("/tasks")
    public  ResponseEntity save(@RequestBody Task task)
    {
        try {
           taskService.save(task);
           return new ResponseEntity(new Mensaje("Tarea guardada con exito"), HttpStatus.ACCEPTED);
        } catch (DataIntegrityViolationException e) {
             return new ResponseEntity(new Mensaje("Usuario no existente"), HttpStatus.BAD_REQUEST);
//             return null;
        }
        
    }
    
    //get una tarea
    @GetMapping("/tasks/{id}")
    public Task getOnetask(@PathVariable Long id)
    {
        return taskService.findById(id);
    }
    
    //Modeficar
    @PutMapping("/tasks/{id}")
    public Task modificar(@RequestBody Task task,@PathVariable Long id)
    {
        Task actualTask= taskService.findById(id);
        actualTask.setTask_name(task.getTask_name());
        actualTask.setTask_resume(task.getTask_resume());
        
        return taskService.save(actualTask);
    }
    
    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable Long id)
    {
        taskService.delete(id);
    }
    
}
