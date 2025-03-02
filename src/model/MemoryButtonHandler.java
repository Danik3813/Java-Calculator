package model;

import controller.fileHandlers.ConfigHandler;
import controller.parsers.ParserCalculationField;
import model.utils.ModelUtils;;

public class MemoryButtonHandler{
    final private int COUNT_HANDLERS = 5;
    private MemoryHandler[] memoryHandlers;

    public MemoryButtonHandler(){
        memoryHandlers = new MemoryHandler[COUNT_HANDLERS];
        memoryHandlers[0] = new MemoryClear();
        memoryHandlers[1] = new MemoryResponse();
        memoryHandlers[2] = new MemoryAdd();
        memoryHandlers[3] = new MemorySubtract();
        memoryHandlers[4] = new MemorySet();
    }

    public String memoryApply(String calculationText, int positionX, ConfigHandler configHandler){
        return memoryHandlers[positionX].apply(calculationText, configHandler);
    }
}

class MemoryClear implements MemoryHandler{
    public String apply(String calculationText, ConfigHandler configHandler){
        configHandler.setMemoryData(0);
        return calculationText;
    }
}

class MemoryResponse implements MemoryHandler{
    public String apply(String calculationText, ConfigHandler configHandler)
    {
        ModelUtils modelUtils = new ModelUtils();
        double memoryData = configHandler.getMemoryData();
        return (memoryData == 0.0) ? "0" : "" + modelUtils.getAccurateValue(memoryData);
    }   
}

class MemoryAdd implements MemoryHandler{
    private final char ARITHMETIC_SIGN = '+';

    public String apply(String calculationText, ConfigHandler configHandler){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils calculationUtils = new ModelUtils(
            configHandler.getMemoryData(), 
            (parserCalculationField.getNumbers()[1] == null) ? parserCalculationField.getNumbers()[0] : parserCalculationField.getNumbers()[1], 
            ARITHMETIC_SIGN
        );
        configHandler.setMemoryData(Double.parseDouble(calculationUtils.equals()));
        return calculationText;
    }
}

class MemorySubtract implements MemoryHandler{
    private final char ARITHMETIC_SIGN = '-';

    public String apply(String calculationText, ConfigHandler configHandler){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        ModelUtils calculationUtils = new ModelUtils(
            configHandler.getMemoryData(), 
            (parserCalculationField.getNumbers()[1] == null) ? parserCalculationField.getNumbers()[0] : parserCalculationField.getNumbers()[1], 
            ARITHMETIC_SIGN
        );
        configHandler.setMemoryData(Double.parseDouble(calculationUtils.equals()));
        return calculationText;
    }
}

class MemorySet implements MemoryHandler{
    public String apply(String calculationText, ConfigHandler configHandler){
        ParserCalculationField parserCalculationField = new ParserCalculationField();
        parserCalculationField.parse(calculationText);
        configHandler.setMemoryData(
            (parserCalculationField.getNumbers()[1] == null) 
            ? parserCalculationField.getNumbers()[0] 
            : parserCalculationField.getNumbers()[1]
        );
        return calculationText;
    }
}
