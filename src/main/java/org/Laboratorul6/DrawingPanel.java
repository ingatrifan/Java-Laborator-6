package org.Laboratorul6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    private Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(100);
        int sides = ConfigPanel.getSides();
        graphics.setColor(ConfigPanel.getColor());
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    public void drawImage(Image image){
        graphics.drawImage(image,0,0,W,H,this);
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    public void resetGraphics(){
        graphics.setColor(new Color(255,255,255,255));
        graphics.fillRect(0, 0, W, H);
        repaint();
    }
}