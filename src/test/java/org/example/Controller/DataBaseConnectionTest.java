package org.example.Controller;

import org.junit.jupiter.api.Assertions;
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
        dataBaseConnection=DataBaseConnection.getInstance();
        connection=mock(dataBaseConnection.getConnection().getClass());
    }
    @Test
    void getInstance_test() {
        var con=DataBaseConnection.getInstance().getConnection();
      assertEquals(dataBaseConnection.getConnection(),con);
    }

    @Test
    void AssertInstanceNotNull(){
        assertNotNull(DataBaseConnection.getInstance().getConnection());
    }

    @Test
    void getConnection_test() {
        var con1=DataBaseConnection.getInstance().getConnection();
        var con2=DataBaseConnection.getInstance().getConnection();
        assertEquals(con1,con2);
    }

    @Test
    void assertConnectionisNotNull() {
        assertNotNull(dataBaseConnection.getConnection());
    }
}