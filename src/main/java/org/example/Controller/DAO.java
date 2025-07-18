package org.example.Controller;

import org.example.Model.User;

import java.util.concurrent.CompletableFuture;

public interface DAO {

    CompletableFuture<String> createUser(User user);

    CompletableFuture<Boolean> readUser(User user);

    CompletableFuture<User> updateUser(User user);

    CompletableFuture<User> deleteUser(User user);
}
