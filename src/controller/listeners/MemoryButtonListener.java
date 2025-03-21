package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;

import javax.swing.JLabel;

import controller.fileHandlers.ConfigHandler;
import view.utils.JMemoryButton;

public class MemoryButtonListener implements ActionListener {
    JLabel calculationField;

    public MemoryButtonListener(JLabel calculationField){
        this.calculationField = calculationField;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        JMemoryButton JSource = (JMemoryButton) event.getSource();
        MemoryButtonHandler memoryButtonHandler = new MemoryButtonHandler();
        ConfigHandler configHandler = new ConfigHandler();
        configHandler.readConfig();
        calculationField.setText(
            memoryButtonHandler.memoryApply(calculationField.getText(), JSource.getPositionX(), configHandler)
        );
        configHandler.saveConfig();
    }
}
