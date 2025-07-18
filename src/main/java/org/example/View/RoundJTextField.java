package org.example.View;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundJTextField extends JTextField {
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false);
    }
    protected void paintComponent(@NotNull Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRoundRect(0, 0, 340, getHeight()-1, 15, 15);
        super.paintComponent(graphics);
    }
    protected void paintBorder(@NotNull Graphics graphics) {
        graphics.setColor(getForeground().darker());
        graphics.drawRoundRect(0, 0, 340, getHeight()-1, 20, 20);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, 340, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}