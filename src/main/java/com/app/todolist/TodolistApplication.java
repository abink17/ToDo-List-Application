package com.app.todolist;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import com.app.todolist.repository.TasksRepository;
import com.app.todolist.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}


}
