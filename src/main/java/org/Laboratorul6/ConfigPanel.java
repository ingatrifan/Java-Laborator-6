package org.Laboratorul6;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel sidesLabel;
    private static JSpinner sidesField;
    private static JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        String[] colorStrings = { "Random","Black"};
        colorCombo = new JComboBox(colorStrings);
        colorCombo.setSelectedIndex(0);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
    public static int getSides() {
        return (Integer)sidesField.getValue();
    }
    public static Color getColor() {
        if(colorCombo.getSelectedItem() == "Black"){
            return Color.BLACK;
        } else {
            Random rand = new Random();
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            return new Color(r,g,b,150);
        }
    }
}