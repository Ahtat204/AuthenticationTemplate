package org.example.View;

import org.example.Controller.AuthenticationController;
import org.example.Controller.Repository;
import org.example.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpView extends Form{
    protected AuthenticationController SignUpConroller=new AuthenticationController(new Repository());
    public SignUpView() {
        super("Signup");
        JLabel signupLabel = new JLabel("signup");
        signupLabel.setBounds(0, 25, 520, 100);
        signupLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        signupLabel.setForeground(Color.decode("#6C15AE"));
        signupLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(signupLabel);
        JLabel EmailLabel = new JLabel("Email");
        EmailLabel.setBounds(70, 110, 420, 30);
        EmailLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        EmailLabel.setForeground(Color.decode("#E3EBFF"));
        add(EmailLabel);
        JTextField emailField = new RoundJTextField(10);
        emailField.setBounds(70 , 140, 450, 55);
        emailField.setBackground(Color.BLUE);
        emailField.setForeground(Color.BLACK);
        emailField.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(emailField);
        JLabel PasswordLabel = new JLabel("Password");
        PasswordLabel.setBounds(70, 190, 420, 30);
        PasswordLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        PasswordLabel.setForeground(Color.decode("#E3EBFF"));
        add(PasswordLabel);
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(70 , 215, 345, 55);
        passwordField.setBackground(Color.BLUE);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(passwordField);
        JLabel ConfirmPasswordLabel = new JLabel("Confirm Password");
        ConfirmPasswordLabel.setBounds(70, 265, 420, 30);
        ConfirmPasswordLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        ConfirmPasswordLabel.setForeground(Color.decode("#E3EBFF"));
        add(ConfirmPasswordLabel);
        JPasswordField confirmPasswordField = new JPasswordField(10);
        confirmPasswordField.setBounds(70 , 290, 345, 55);
        confirmPasswordField.setBackground(Color.BLUE);
        confirmPasswordField.setForeground(Color.BLACK);
        confirmPasswordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(confirmPasswordField);
        JLabel alreadyhavecount = new JLabel("Already have a count?");
        alreadyhavecount.setFont(new Font(Font.SERIF, Font.PLAIN, 18));
        alreadyhavecount.setForeground(Color.decode("#E3EBFF"));
        alreadyhavecount.setBounds(120 , 330, 480, 55);
        add(alreadyhavecount);
        JLabel LoginLabel = new JLabel("Login");
        LoginLabel.setBounds(290, 345, 400, 25);
        LoginLabel.setForeground(Color.decode("#FF0000"));
        LoginLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        LoginLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(LoginLabel);
        LoginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new LoginView().setVisible(true);
                SignUpView.this.setVisible(false);
            }
        });
        JButton SignUpButton = new JButton("Sign Up");
        SignUpButton.setBounds(215, 390, 100, 25);
        SignUpButton.setForeground(Color.decode("#E3EBFF"));
        SignUpButton.setBackground(Color.decode("#518E88"));
        SignUpButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        SignUpButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(SignUpButton);
        SignUpButton.addActionListener(e -> {
            User user=new User(emailField.getText(),passwordField.getPassword().toString());
            if(confirmPasswordField.getPassword().toString().equals(new String(passwordField.getPassword().toString()))){
                Form.ThrowErrorWindow("Passwords do not match");
            }
            SignUpConroller.SignUp(user).thenAccept(result -> {
                Form.ThrowErrorWindow(result);
            });

        });
    }
}
