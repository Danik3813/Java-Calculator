package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import controller.file_handlers.ConfigHandler;
import controller.listeners.CalculationButtonListener;
import controller.listeners.MemoryButtonListener;
import view.utils.*;

public class CalculatorGUI extends JFrame{
    final String ICON_PATH = "resources/calculatorIcon.png";
    // Текст панели элементов
    final String[] memoryButtons = {"MC", "MR", "M+", "M-", "MS"};
    final String[][] calculationButtons = {
        {"%", "CE", "C", "⌫"}, 
        {"1/x", "x^2", "√", "/"}, 
        {"7", "8", "9", "*"}, 
        {"4", "5", "6", "-"}, 
        {"1", "2", "3", "+"}, 
        {"+/-", "0", ".", "="}
    };
    JLabel calculationField;

    public CalculatorGUI(String title)
    {
        super(title);
    }

    public void initializeGUI(int width, int height)
    {
        setSize(width, height);
        setMinimumSize(new Dimension(450, 500));
        this.setLayout(new GridBagLayout());

        initializeCalculationField();
        initializeMemoryPanel();
        initializeCalculationPanel();

        initializeIcon();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initializeIcon(){
        ImageIcon calculatorIcon = new ImageIcon(ICON_PATH);
        setIconImage(calculatorIcon.getImage());
    }

    private void initializeCalculationField(){
        GridBagConstraints regularGrid = new GridBagConstraints();
        regularGrid.gridx = 0; regularGrid.gridy = 0;
        regularGrid.weightx = 1.0; regularGrid.weighty = 0.35;
        regularGrid.fill = GridBagConstraints.BOTH;

        calculationField = new JLabel("0");
        calculationField.setFont(new Font("Arial", Font.BOLD, 32));
        this.add(calculationField, regularGrid);
    }

    private void initializeMemoryPanel()
    {
        GridBagConstraints regularGrid = new GridBagConstraints();
        regularGrid.gridx = 0; regularGrid.gridy = 1;
        regularGrid.weightx = 1.0; regularGrid.weighty = 0.05;
        regularGrid.fill = GridBagConstraints.BOTH;

        JPanel memoryPanel = new JPanel(new GridLayout(1, 5, 2, 0));
        for (int i = 0; i < memoryButtons.length; ++i){
            JButton memoryButton = new JMemoryButton(memoryButtons[i], i);
            // ConfigHandler configHandler = new ConfigHandler();
            // if (configHandler.getMemoryData() == 0.0){
            //     if (i == 0 || i == 1) memoryButton.setEnabled(false);
            // }
            memoryButton.addActionListener(new MemoryButtonListener(calculationField));
            memoryPanel.add(memoryButton);
        }
        this.add(memoryPanel, regularGrid);
    }

    private void initializeCalculationPanel()
    {
        GridBagConstraints regularGrid = new GridBagConstraints();
        regularGrid.gridx = 0; regularGrid.gridy = 2;
        regularGrid.weightx = 1.0; regularGrid.weighty = 0.7;
        regularGrid.fill = GridBagConstraints.BOTH;

        JPanel calculationPanel = new JPanel(new GridLayout(6, 4, 2, 2));
        for (int i = 0; i < calculationButtons.length; i++){
            for (int j = 0; j < calculationButtons[i].length; j++){
                JCalculationButton calculationButton = new JCalculationButton(calculationButtons[i][j], i, j);
                calculationButton.addActionListener(new CalculationButtonListener(calculationField));
                calculationPanel.add(calculationButton);
            }
        }
        this.add(calculationPanel, regularGrid);
    }
}
