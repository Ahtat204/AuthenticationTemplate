package org.example.View;

import javax.swing.*;
import java.awt.*;

public class Form extends JFrame {
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
    public static void ThrowErrorWindow(String e) {
        JFrame frame = new JFrame(e);
    }
}