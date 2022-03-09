/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.service;

import com.kanban.dao.TaskDao;
import com.kanban.model.Task;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sergio
 */
@Service
public class TaskServiceImp implements TaskService{

    @Autowired
    private TaskDao taskDao;
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    @Transactional(readOnly = true)
    public List<Task> listTasks() {
        return (List<Task>) taskDao.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskDao.save(task);
    }

    @Override
    public void delete(Long id) {
        taskDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return taskDao.findById(id).orElse(null);
    }

    @Override
    public List<Task> TasksByUser(Long id_user) {

        List<Task> tasks_by_user = entityManager.createNativeQuery("select * from task where id_user = :id_user", Task.class)
                .setParameter("id_user", id_user).getResultList();
        return tasks_by_user;
    }
    
}
