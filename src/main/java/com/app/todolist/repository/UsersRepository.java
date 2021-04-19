package com.app.todolist.repository;

import com.app.todolist.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    public Users save(Users users);
//    public String findByName(String email);
}
