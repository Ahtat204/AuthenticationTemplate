package org.example.Controller;

import org.example.Model.User;

import java.util.concurrent.CompletableFuture;

/**
Following the MVC architecture , this class is the Controller
 */
public class AuthenticationController {
    protected Repository Repository ;
    public AuthenticationController(Repository repository) {
        Repository = repository;
    }
    public CompletableFuture<Boolean> SignUp(User user) {
        return Repository.createUser(user);
    }
    public CompletableFuture<Boolean> SignIn(User user) {
        return Repository.readUser(user);
    }
}
