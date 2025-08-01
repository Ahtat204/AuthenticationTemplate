package org.example.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DataBaseConnectionTest {

    private DataBaseConnection dataBaseConnection;
    private Connection connection;


    @BeforeEach
    void setUp() throws Exception {
        dataBaseConnection=new DataBaseConnection();
        connection=mock(dataBaseConnection.getConnection().getClass());
    }
    @Test
    void getInstance() {
    }

    @Test
    void getConnection() {
    }
}