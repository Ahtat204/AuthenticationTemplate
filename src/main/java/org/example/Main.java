package org.example;

import org.example.Controller.Repository;
import org.example.Model.User;
import org.example.View.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
}
