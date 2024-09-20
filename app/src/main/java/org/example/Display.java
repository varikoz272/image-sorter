package org.example;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.example.sort.SortStrategy;

public class Display extends Canvas {
    private SortStrategy strategy;

    private BufferedImage img;

    public Display(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(BufferedImage img) {
        this.img = img;/* new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB); */
        strategy.setArray(((DataBufferInt) img.getRaster().getDataBuffer()).getData());
        Thread sortThread = new Thread(strategy);
        sortThread.start();

        while (sortThread.isAlive()) {
            draw();
        }
    }

    public void draw() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();
        g2.drawImage(img, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
        bs.show();
    }

    public static BufferedImage imageFromFile(File file) {
        BufferedImage imgByte;

        try {
            imgByte = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            return null;
        }

        BufferedImage out = new BufferedImage(imgByte.getWidth(), imgByte.getHeight(), BufferedImage.TYPE_INT_RGB);
        int[] colors = ((DataBufferInt) out.getRaster().getDataBuffer()).getData();

        for (int x = 0; x < imgByte.getWidth(); x++)
            for (int y = 0; y < imgByte.getHeight(); y++)
                colors[x + y * imgByte.getWidth()] = imgByte.getRGB(x, y);

        return out;
    }

    public void changeSpeed(int value) {
        strategy.setSleepTime(strategy.getSleepTime() + value);
    }

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

}
