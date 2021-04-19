package com.app.todolist.repository;

import com.app.todolist.model.Tasks;
import com.app.todolist.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
    public List<String> findTasks(String username);
    public Tasks save(Tasks tasks);

    @Query(value = "select * from Tasks t where t.username= :username", nativeQuery = true)
    public List<Tasks> findTasksDetailsByName(@Param("username") String username);

    @Modifying
    @Query(value = "delete from Tasks t where t.task= :task and t.username= :username", nativeQuery = true)
    public void removeTasks(@Param("task") String task, @Param("username") String username);
}
