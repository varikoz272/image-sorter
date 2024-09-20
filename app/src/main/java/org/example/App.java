package org.example;

import java.io.File;

import javax.swing.JFrame;

import org.example.sort.BubbleSort;

public class App {

    public static void main(String[] args) {
        int width = 800;
        int height = 800;

        JFrame frame = new JFrame();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Display d = new Display(new BubbleSort());
        frame.add(d);
        d.sort(Display.imageFromFile(new File("/home/admin-nahren/Desktop/Untitled.png")));

        frame.pack();
    }
}
