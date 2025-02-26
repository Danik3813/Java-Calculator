package model;

public class CalculationButtonHandler {
    final private int ROW_COUNT_HANDLERS = 6;
    final private int COLUMN_COUNT_HANDLERS = 4;
    private CalculationHandler[][] calculationHandlers;

    public CalculationButtonHandler(){
        calculationHandlers = new CalculationHandler[ROW_COUNT_HANDLERS][COLUMN_COUNT_HANDLERS];
        // Инициализация массива функций
        calculationHandlers[0][0] = new CalculationPercent();
        for (int i = 2; i < 5; i++){
            for (int j = 0; j < 3; j++){
                calculationHandlers[i][j] = new CalculationNumber();
            }
        }
        calculationHandlers[5][1] = new CalculationNumber();
    }

    public String calculationApply(String text, int positionX, int positionY){
        return calculationHandlers[positionX][positionY].apply(text, positionX, positionY);
    }
}

class CalculationPercent implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        return "" + Double.parseDouble(calculationText) / 100;
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
