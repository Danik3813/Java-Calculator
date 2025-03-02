package model;

import controller.parsers.ParserCalculationField;
import controller.parsers.utils.ParserUtils;
import model.utils.ModelUtils;

public class CalculationButtonHandler {
    final private int ROW_COUNT_HANDLERS = 6;
    final private int COLUMN_COUNT_HANDLERS = 4;
    private CalculationHandler[][] calculationHandlers;

    public CalculationButtonHandler(){
        calculationHandlers = new CalculationHandler[ROW_COUNT_HANDLERS][COLUMN_COUNT_HANDLERS];

        calculationHandlers[0][0] = new CalculationPercent();
        calculationHandlers[0][1] = new CalculationClearEntry();
        calculationHandlers[0][2] = new CalculationClear();
        calculationHandlers[0][3] = new CalculationDelete();
        calculationHandlers[1][0] = new CalculationDivide();
        calculationHandlers[1][1] = new CalculationSquare();
        calculationHandlers[1][2] = new CalculationSquareRoot();
        for (int i = 2; i < ROW_COUNT_HANDLERS - 1; i++){
            for (int j = 0; j < COLUMN_COUNT_HANDLERS - 1; j++){
                calculationHandlers[i][j] = new CalculationNumber();
            }
        }
        calculationHandlers[5][0] = new CalculationChangeSign();
        calculationHandlers[5][1] = new CalculationNumber();
        for (int i = 1; i < ROW_COUNT_HANDLERS - 1; ++i){
            calculationHandlers[i][COLUMN_COUNT_HANDLERS - 1] = new CalculationCalculate();
        }
        calculationHandlers[5][2] = new CalculationDelimeter();
        calculationHandlers[5][3] = new CalculationEquals();
    }

    public String calculationApply(String calculationText, int positionX, int positionY){
        return calculationHandlers[positionX][positionY].apply(calculationText, positionX, positionY);
    }
}

class CalculationPercent implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils modelUtils = new ModelUtils(
            parserCalculationField.getNumbers()[0], 
            parserCalculationField.getNumbers()[1], 
            parserCalculationField.getDelimeter()
        );
        return modelUtils.percent();
    }
}

class CalculationDivide implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils modelUtils = new ModelUtils(
            parserCalculationField.getNumbers()[0], 
            parserCalculationField.getNumbers()[1], 
            parserCalculationField.getDelimeter()
        );
        return modelUtils.calculationDivideOneByNumber();
    }
}

class CalculationClearEntry implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ModelUtils modelUtils = new ModelUtils();
        if (calculationText.equals(modelUtils.ERROR_MESSAGE)) return "0";
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        modelUtils.setNum1(parserCalculationField.getNumbers()[0]);
        modelUtils.setNum2(parserCalculationField.getNumbers()[1]);
        modelUtils.setDelimeter(parserCalculationField.getDelimeter());
        return modelUtils.clearEntry();
    }
}

class CalculationSquare implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils modelUtils = new ModelUtils(
            parserCalculationField.getNumbers()[0], 
            parserCalculationField.getNumbers()[1], 
            parserCalculationField.getDelimeter()
        );
        return modelUtils.calculationSquare();
    }
}

class CalculationSquareRoot implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils modelUtils = new ModelUtils(
            parserCalculationField.getNumbers()[0], 
            parserCalculationField.getNumbers()[1], 
            parserCalculationField.getDelimeter()
        );
        return modelUtils.calculationSquareRoot();
    }
}

class CalculationClear implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ModelUtils modelUtils = new ModelUtils();
        return modelUtils.clear();
    }
}

// TODO: вынести реализацию класса в ParserUtils / ModelUtils
class CalculationNumber implements CalculationHandler{
    final private String numbers[][] = {
        {"7", "8", "9"},
        {"4", "5", "6"},
        {"1", "2", "3"}
    };

    public String apply(String calculationText, int positionX, int positionY){
        if (calculationText.charAt(0) == '0' && calculationText.length() == 1){
            return (positionX == 5 && positionY == 1) ? "0" : numbers[positionX - 2][positionY];
        }
        else{
            return (positionX == 5 && positionY == 1) ? calculationText + "0" : calculationText + numbers[positionX - 2][positionY];
        }
    }
}

class CalculationCalculate implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserUtils parserUtils = new ParserUtils();
        if (parserUtils.isOperator(calculationText.charAt(calculationText.length() - 1))) 
            return calculationText;
        else {
            ParserCalculationField parserCalculationField = new ParserCalculationField();
            parserCalculationField.parse(calculationText);
            ModelUtils modelUtils = new ModelUtils(
                parserCalculationField.getNumbers()[0], 
                parserCalculationField.getNumbers()[1], 
                parserCalculationField.getDelimeter()
            );
            return modelUtils.calculate(parserUtils.getOperator(positionX));
        }
    }
}

// TODO: вынести реализацию класса в ParserUtils / ModelUtils
class CalculationDelete implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ModelUtils modelUtils = new ModelUtils();
        if (calculationText.length() == 1 || calculationText.equals(modelUtils.ERROR_MESSAGE)) 
            return "0";
        return calculationText.substring(0, calculationText.length() - 1);
    }
}

class CalculationChangeSign implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils modelUtils = new ModelUtils(
            parserCalculationField.getNumbers()[0], 
            parserCalculationField.getNumbers()[1], 
            parserCalculationField.getDelimeter()
        );
        return modelUtils.changeSign();
    }
}

class CalculationDelimeter implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserUtils parserUtils = new ParserUtils();
        if (parserUtils.isOperator(calculationText.charAt(calculationText.length() - 1))) 
            return calculationText;
        else{
            ParserCalculationField parserCalculationField = new ParserCalculationField();
            parserCalculationField.parse(calculationText);
            ModelUtils modelUtils = new ModelUtils(
                parserCalculationField.getNumbers()[0], 
                parserCalculationField.getNumbers()[1], 
                parserCalculationField.getDelimeter()
            );
            return modelUtils.concatDelimeter();
        }
    }
}

class CalculationEquals implements CalculationHandler{
    public String apply(String calculationText, int positionX, int positionY){
        ParserUtils parserUtils = new ParserUtils();
        if (parserUtils.isOperator(calculationText.charAt(calculationText.length() - 1)))
            return calculationText.substring(0, calculationText.length() - 1);
        else {
            ParserCalculationField parserCalculationField = new ParserCalculationField();
            parserCalculationField.parse(calculationText);
            ModelUtils modelUtils = new ModelUtils(
                parserCalculationField.getNumbers()[0], 
                parserCalculationField.getNumbers()[1], 
                parserCalculationField.getDelimeter()
            );
            return modelUtils.equals();
        }
    }
}