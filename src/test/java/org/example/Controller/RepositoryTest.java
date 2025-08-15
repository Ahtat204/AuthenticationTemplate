package org.example.Controller;

import org.example.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
class RepositoryTest {

    private Connection mockConnection;
    private PreparedStatement mockStatement;
    private ResultSet mockResultSet;
    private Repository repository;

    @BeforeEach
    void setUp() {
        mockConnection = mock(DataBaseConnection.getInstance().getConnection().getClass());
        mockStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);
        repository = new Repository(mockConnection);
    }

    @Test
    void testCreateUser_Success() throws Exception {
        User testUser = new User("test@example.com", "password123");

        when(mockConnection.prepareStatement(anyString(), eq(Statement.RETURN_GENERATED_KEYS)))
                .thenReturn(mockStatement);

        when(mockStatement.executeUpdate()).thenReturn(1);
        when(mockStatement.getGeneratedKeys()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);
        CompletableFuture<Boolean> resultFuture = repository.createUser(testUser);
        assertTrue(resultFuture.get());
    }

    @Test
    void testReadUser_Success() throws Exception {
        User testUser = new User("test@example.com", "password123");

        when(mockConnection.prepareStatement(anyString()))
                .thenReturn(mockStatement);

        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true); // user found

        CompletableFuture<Boolean> resultFuture = repository.readUser(testUser);
        assertTrue(resultFuture.get());
    }

    @Test
    void testReadUser_NotFound() throws Exception {
        User testUser = new User("fake@examp.com", "wropass");

        when(mockConnection.prepareStatement(anyString()))
                .thenReturn(mockStatement);

        when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false); // user not found

        CompletableFuture<Boolean> resultFuture = repository.readUser(testUser);
        assertFalse(resultFuture.get());
    }
}
