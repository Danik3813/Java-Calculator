package controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel; 
import model.CalculationButtonHandler;
import view.utils.JCalculationButton;

public class CalculationButtonListener implements ActionListener {
    JLabel calculationField;

    public CalculationButtonListener(JLabel calculationField){
        this.calculationField = calculationField;
    }

    @Override
    public void actionPerformed(ActionEvent event){
        JCalculationButton JSource = (JCalculationButton) event.getSource();
        CalculationButtonHandler calculcationButtonHandler = new CalculationButtonHandler();
        calculationField.setText(
            calculcationButtonHandler.calculationApply(calculationField.getText(), JSource.getPositionX(), JSource.getPositionY())
        );
    }
}
