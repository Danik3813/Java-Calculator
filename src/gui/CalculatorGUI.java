package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalculatorGUI extends JFrame{

    public CalculatorGUI(String title)
    {
        super(title);
        this.setLayout(new GridLayout(3, 1));
    }

    public void initializeGUI(int width, int height)
    {
        setSize(width, height);
        initializeCalculationField();
        initializeMemoryPanel();
        initializeCalculationPanel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeCalculationField(){
        JLabel calculationField = new JLabel("0");
        this.add(calculationField);
    }

    private void initializeMemoryPanel()
    {
        JPanel memoryPanel = new JPanel();
        final String[] memoryButtons = {"MC", "MR", "M+", "M-", "MS"};
        for (int i = 0; i < memoryButtons.length; ++i){
            memoryPanel.add(new JButton(memoryButtons[i]));
        }
        this.add(memoryPanel);
    }

    private void initializeCalculationPanel()
    {
        JPanel calculationPanel = new JPanel(new GridLayout(6, 4, 2, 2));
        final String[][] calculationButtons = {{"%", "CE", "C", "del"}, {"1/x", "x^2", "sqrt(x)", "/"}, {"7", "8", "9", "*"}, {"4", "5", "6", "-"}, {"1", "2", "3", "+"}, {"+/-", "0", ",", "="}};
        for (int i = 0; i < calculationButtons.length; ++i){
            for (int j = 0; j < calculationButtons[i].length; ++j){
                JButton calculationButton = new JButton(calculationButtons[i][j]);
                calculationPanel.add(calculationButton);
            }
        }
        this.add(calculationPanel);
    }
}
