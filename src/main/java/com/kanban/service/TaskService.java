package com.kanban.service;

import com.kanban.model.Task;
import java.util.List;

/**
 *
 * @author Sergio
 */
public interface TaskService {
    public List<Task> listTasks();
    public Task save(Task task);
    public Task findById(Long id);
    public void delete(Long id);
    public List <Task> TasksByUser(Long id_user);
}
