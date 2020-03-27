package org.Laboratorul6;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    static JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        //create the colorCombo, containing the values: Random and Black
        String[] colorStrings = { "Random","Black"};
        colorCombo = new JComboBox(colorStrings);
        colorCombo.setSelectedIndex(2);
        colorCombo.addActionListener((ActionListener) this);
        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }
    public static JLabel getSidesLabel() {
        return sidesLabel;
    }

}