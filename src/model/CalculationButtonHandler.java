package model;

import controller.parsers.ParserCalculationField;

public class CalculationButtonHandler {
    final private int ROW_COUNT_HANDLERS = 6;
    final private int COLUMN_COUNT_HANDLERS = 4;
    private CalculationHandler[][] calculationHandlers;

    public CalculationButtonHandler(){
        calculationHandlers = new CalculationHandler[ROW_COUNT_HANDLERS][COLUMN_COUNT_HANDLERS];
        // Инициализация кнопки процента
        calculationHandlers[0][0] = new CalculationPercent();
        // Инициализация кнопок-цифр (от 1 по 9)
        for (int i = 2; i < ROW_COUNT_HANDLERS - 1; i++){
            for (int j = 0; j < COLUMN_COUNT_HANDLERS - 1; j++){
                calculationHandlers[i][j] = new CalculationNumber();
            }
        }
        // Инициализация кнопки нуля
        calculationHandlers[5][1] = new CalculationNumber();
    }

    public String calculationApply(String calculationText, int positionX, int positionY){
        return calculationHandlers[positionX][positionY].apply(calculationText, positionX, positionY);
    }
}

class CalculationPercent implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        return "" + (parserCalculationField.getNumbers()[1] / 100);
    }
}

class CalculationNumber implements CalculationHandler{
    final private String numbers[][] = {
        {"7", "8", "9"},
        {"4", "5", "6"},
        {"1", "2", "3"}
    };

    public String apply(String calculationText, int positionX, int positionY){
        if (calculationText.charAt(0) == '0'){
            return (positionX == 5 && positionY == 1) ? "0" : numbers[positionX - 2][positionY];
        }
        else{
            return (positionX == 5 && positionY == 1) ? calculationText + "0" : calculationText + numbers[positionX - 2][positionY];
        }
    }
}

class CalculationPlus implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        return null;
    }
}
