package org.example.Controller;

import org.example.Model.User;

import java.util.concurrent.CompletableFuture;

/**
Following the MVC architecture , this class is the Controller
 */
public class AuthenticationController {
    protected Repository Repository ;
    public void LoginSignUpController(Repository Repository) {
        this.Repository = Repository;
    }

    public AuthenticationController(org.example.Controller.Repository repository) {
        Repository = repository;
    }

    public CompletableFuture<Boolean> SignUp(User user) {
        return Repository.createUser(user);
    }
    public CompletableFuture<Boolean> SignIn(User user) {
        return Repository.readUser(user);
    }
}
