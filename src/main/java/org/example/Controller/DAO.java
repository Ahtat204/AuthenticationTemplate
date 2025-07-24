package org.example.Controller;
import org.example.Model.User;
import java.util.concurrent.CompletableFuture;
/**
 * this interface represent the Data Access Object for the DataBase,
 */
public interface DAO {
    /**
     * this method is used to insert a user into the DataBase
     *
     * @param user user is a record , which is a value type , better than a class for representing Entities
     * @return it return CompletableFuture<String> which is like C#'s Task<String>, Asynchronous
     */
    CompletableFuture<Boolean> createUser(User user);
    /**
     * this method is used to Check if the user exists in the DataBase
     *
     * @param user user is a record , which is a value type , better than a class for representing Entities
     * @return it return CompletableFuture<Boolean> which is like C#'s Task<bool>, Asynchronous
     */

    CompletableFuture<Boolean> readUser(User user);

    CompletableFuture<User> updateUser(User user);

    CompletableFuture<User> deleteUser(User user);
}
