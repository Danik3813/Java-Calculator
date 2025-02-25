package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.utils.JMemoryButton;

public class MemoryButtonListener implements ActionListener {
    JLabel calculationField;

    public MemoryButtonListener(JLabel calculationField){
        this.calculationField = calculationField;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        calculationField.setText("sex");
        JMemoryButton JSource = (JMemoryButton) event.getSource();
        
    }
}
