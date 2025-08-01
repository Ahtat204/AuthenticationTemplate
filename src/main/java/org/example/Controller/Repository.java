package org.example.Controller;
import org.example.Model.User;
import org.jetbrains.annotations.NotNull;
import java.sql.*;
import java.util.concurrent.CompletableFuture;

/**
 * for best architectural design ,
 * we used the Repository pattern to be the middleman between our DAO and the MVC controller,
 * by implementing the DAO
 */
public class Repository implements DAO {

    private final Connection connection;

    public Repository() {
        this.connection = DataBaseConnection.getInstance().getConnection();
    }

    /**
     * an overloaded constructor for testing purposes
     *
     * @param connection
     */
    public Repository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public CompletableFuture<Boolean> createUser(@NotNull User user) {
        return CompletableFuture.supplyAsync(() -> {
            var query = "INSERT INTO user(email,password) VALUES (?,?)";
            try (var preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.Email());
                preparedStatement.setString(2, user.Password());

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                        if (keys.next()) {
                            int id = keys.getInt(1);
                            return true;
                        }
                    }
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

    @Override
    public CompletableFuture<Boolean> readUser(@NotNull User user) {
        return CompletableFuture.supplyAsync(() -> {
            var query = "SELECT * FROM user WHERE email = ? AND password = ?";
            try (var preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, user.Email());
                preparedStatement.setString(2, user.Password());
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        });
    }

    /**
     * this method is going to be used for  password resetting, in case of forgetting it
     */
    @Override
    public CompletableFuture<User> updateUser(@NotNull User user) {
        return CompletableFuture.supplyAsync(() -> {
            String query = "UPDATE users SET  password = ? WHERE email = ?";
            try (PreparedStatement Statement = connection.prepareStatement(query)) {
                Statement.setString(1, user.Password());
                Statement.setString(2, user.Email());
                Statement.executeUpdate();
                return user;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;

            }
        });

    }

    @Override
    public CompletableFuture<User> deleteUser(User user) {
        return CompletableFuture.completedFuture(user);
    }
}


