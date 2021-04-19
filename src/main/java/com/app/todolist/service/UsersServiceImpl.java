package com.app.todolist.service;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import com.app.todolist.repository.TasksRepository;
import com.app.todolist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.Authenticator;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    @Transactional
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void addTasks(String task, String username) {
        Tasks tasks = new Tasks();
        tasks.setTask(task);
        tasks.setUsername(username);
        Timestamp last_update_time = new Timestamp(System.currentTimeMillis());
        tasks.setUpdate_time(last_update_time);
        tasksRepository.save(tasks);
    }

    @Override
    public List<Tasks> getTasksDetails(String name) {
        List<Tasks> task_details =  tasksRepository.findTasksDetailsByName(name);
        return task_details;
    }

    @Override
    @Transactional
    public void deleteTasks(String task, String name) {
        tasksRepository.removeTasks(task, name);
    }
}
