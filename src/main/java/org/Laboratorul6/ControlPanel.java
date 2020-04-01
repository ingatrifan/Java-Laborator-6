package org.Laboratorul6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private JButton saveBtn = new JButton("Save");
    private JButton loadBtn = new JButton("Load");
    private JButton resetBtn = new JButton("Reset");
    private JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("/home/batman/paint.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        try {
            Image image = ImageIO.read(new File("/home/batman/1.jpg"));
            frame.canvas.drawImage(image);
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void reset(ActionEvent e) {
        frame.canvas.resetGraphics();
    }

    private void exit(ActionEvent e) {
            frame.setVisible(false);
            frame.dispose();
    }
}