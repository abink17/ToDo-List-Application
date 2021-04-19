package com.app.todolist.service;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UsersService {
    public void saveUser(Users users);

    public void addTasks(String task, String name);

    public List<Tasks> getTasksDetails(String name);

    public void deleteTasks(String task, String name);

}
