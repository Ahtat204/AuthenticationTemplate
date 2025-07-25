package org.example.View;

import com.example.View.Result;
import org.example.Controller.AuthenticationController;
import org.example.Controller.Repository;
import org.example.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public non-sealed class LoginView extends Form {

    public AuthenticationController loginController = new AuthenticationController(new Repository());
    Result processResult;

    public LoginView() {
        super("Login");
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(0, 25, 520, 100);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 30));
        loginLabel.setForeground(Color.decode("#6C15AE"));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);
        JLabel usernameLabel = new JLabel("Email");
        usernameLabel.setBounds(70, 120, 400, 25);
        usernameLabel.setForeground(Color.decode("#E3EBFF"));
        usernameLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        add(usernameLabel);
        JTextField EmailFiledtext = new RoundJTextField(10);
        EmailFiledtext.setBounds(70, 150, 450, 55);
        EmailFiledtext.setBackground(Color.BLUE);
        EmailFiledtext.setForeground(Color.BLACK);
        EmailFiledtext.setFont(new Font("Dialog", Font.PLAIN, 18));


        add(EmailFiledtext);
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(70, 210, 400, 25);
        passwordLabel.setForeground(Color.decode("#E3EBFF"));
        passwordLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        add(passwordLabel);
        JPasswordField passwordField = new JPasswordField(10);
        passwordField.setBounds(70, 238, 345, 55);
        passwordField.setBackground(Color.WHITE);
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 18));
        add(passwordField);
        JLabel noaccount = new JLabel("Don't have an account?");
        noaccount.setBounds(70, 290, 400, 25);
        noaccount.setForeground(Color.decode("#E3EBFF"));
        noaccount.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        add(noaccount);
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setBounds(320, 290, 400, 25);
        signUpLabel.setForeground(Color.decode("#FF0000"));
        signUpLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        add(signUpLabel);
        signUpLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new SignUpView();
                LoginView.this.setVisible(false);
            }
        });
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 340, 100, 25);
        loginButton.setForeground(Color.decode("#E3EBFF"));
        loginButton.setBackground(Color.decode("#518E88"));
        loginButton.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 18));
        add(loginButton);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(e -> {
                    var email = EmailFiledtext.getText();
                    var password = String.valueOf(passwordField.getPassword());
                    var user = new User(EmailFiledtext.getText(), passwordField.getPassword().toString());
                    loginController.SignIn(user).thenAccept(result -> {
                        processResult = new Result(
                                result ? "login Successfully" : "login Failed",
                                result ? Color.GREEN : Color.RED
                        );
                    });


                }

        );
    }

}
