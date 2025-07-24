package com.example.View
import java.awt.Color
import javax.swing.JFrame
import javax.swing.JLabel

class Result(){
    constructor(text: String, color:Color) : this() {
        val frame = JFrame("Result")
        frame.setSize(200, 200)
        val label = JLabel(text, JLabel.CENTER)
        label.setForeground(color)
        frame.add(label)
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}