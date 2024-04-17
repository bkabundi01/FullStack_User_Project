package com.fullstack.userfullstack_server.model;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long userId;
    private String userName;
    private String name;
    private String email;
    private boolean userDeleted; //determines whether the user is marked as deleted or not

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUserId() {return userId;}

    public void setUserId(long userId) {this.userId = userId;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getUserDeleted() {return userDeleted;}

    public void setUserDeleted(boolean userDeleted) {this.userDeleted = userDeleted;}
}
