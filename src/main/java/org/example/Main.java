package org.example;

import org.example.View.LoginView;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
    }
    }
