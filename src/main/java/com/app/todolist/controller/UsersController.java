package com.app.todolist.controller;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import com.app.todolist.repository.TasksRepository;
import com.app.todolist.repository.UsersRepository;
import com.app.todolist.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/addTask")
    public String addTask(){
        return "addtask";
    }

    @GetMapping("/userTask")
    public String userTask(@RequestParam(name = "task", required = false) String task, Model model, Principal principal){
        usersService.addTasks(task, principal.getName());

        model.addAttribute("username", principal.getName());
        model.addAttribute("userTasks", usersService.getTasksDetails(principal.getName()));
        return "userlogin";
    }

    @GetMapping("")
    public String usreHomePage(Model model, Principal principal){
        model.addAttribute("username", principal.getName());
        model.addAttribute("userTasks", usersService.getTasksDetails(principal.getName()));
        return "userlogin";
    }

    @GetMapping("/delete_task")
    public String deleteTask(@RequestParam(name="task") String task, Model model, Principal principal){
        usersService.deleteTasks(task, principal.getName());

        model.addAttribute("username", principal.getName());
        model.addAttribute("userTasks", usersService.getTasksDetails(principal.getName()));
        return "userlogin";
    }
}
