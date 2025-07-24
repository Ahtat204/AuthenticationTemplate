package org.example.View;

import javax.swing.*;
import java.awt.*;

/**
 * the base class of the SignUp Form and LoginForm , it's Sealed to prevent any non-UI classes to inherit from it
 */
public sealed class Form extends JFrame permits LoginView, SignUpView {
    String IconPath = System.getenv("iconpath");
    ImageIcon icon = new ImageIcon(IconPath);
    public Form(String title) {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.BLACK);
        setResizable(false);
        setIconImage(icon.getImage());

    }
    /**
     * this this method is a utility method ,
     * for example if the user is successfully created in the DataBase , we use this method to show that
     */
    public static JFrame ThrowErrorWindow(String e) {
        return new JFrame(e);
    }

}