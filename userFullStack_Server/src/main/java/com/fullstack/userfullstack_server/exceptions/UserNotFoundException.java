package com.fullstack.userfullstack_server.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException (Long user_id) {
        super("Could Not Find User With ID: " + user_id);
    }
}
