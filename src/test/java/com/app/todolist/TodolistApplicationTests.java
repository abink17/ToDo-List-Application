package com.app.todolist;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import com.app.todolist.repository.TasksRepository;
import com.app.todolist.repository.UsersRepository;
import static org.assertj.core.api.Assertions.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = TodolistApplication.class)
class TodolistApplicationTests {

	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private UsersRepository usersRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void addUser(){
		Users temp_user = new Users();
		temp_user.setName("temp");
		temp_user.setPassword("temp123");
		usersRepository.save(temp_user);
		assertThat(temp_user.getName()).isEqualTo("temp");
		assertThat(temp_user.getPassword()).isEqualTo("temp123");
	}

	@Test
	public void addTask_fromUserHomePage(){
		Tasks temp_task = new Tasks();
		temp_task.setUsername("random guy");
		temp_task.setTask("temporary to do task");
		tasksRepository.save(temp_task);
		assertThat(temp_task.getUsername()).isEqualTo("random guy");
		assertThat(temp_task.getTask()).isEqualTo("temporary to do task");
	}

	@Test
	public void findTasksDetails_forUser() {
		Tasks temp_task = new Tasks();
		temp_task.setUsername("Zach");
		temp_task.setTask("Release Snyder cut");
		List<Tasks> temp_list = (List<Tasks>) tasksRepository.findTasksDetailsByName("Zach");
		assertThat(temp_list.contains(temp_task));
	}

	@Test
	public void deleteTask() {
		Tasks temp_task = new Tasks();
		temp_task.setUsername("Mark");
		temp_task.setTask("Try painting");
		List<Tasks> temp_delete_list = (List<Tasks>) tasksRepository.findTasksDetailsByName("Zach");
		assertFalse(temp_delete_list.contains(temp_task));
	}
}
