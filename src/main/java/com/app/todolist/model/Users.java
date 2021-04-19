package com.app.todolist.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "password", length = 45, nullable = false)
    private String password;

    public Users() {
    }

    public void Users(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
