package com.api.booker.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer user_id;

    private String username;

    private String password;

    private String state;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String isState() { return state; }

    public void setState(String state) { this.state = state; }

    public UserEntity() {
    }

    public UserEntity(String username, String password, String state) {
        this.username = username;
        this.password = password;
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
