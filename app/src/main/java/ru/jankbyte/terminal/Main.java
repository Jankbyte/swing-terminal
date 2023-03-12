package ru.jankbyte.terminal;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import java.awt.Dimension;


public class Main {
    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Terminal terminal = new Terminal(100, 30);
        frame.add(terminal, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
    }
}
