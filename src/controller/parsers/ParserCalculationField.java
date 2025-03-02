package controller.parsers;

import controller.parsers.utils.ParserUtils;

public class ParserCalculationField {
    private final int COUNT_NUMBERS = 2;
    private Double[] numbers;
    private char delimeter;

    public ParserCalculationField() {
        numbers = new Double[COUNT_NUMBERS];
    }

    public Double[] getNumbers() {
        return numbers;
    }

    public char getDelimeter() {
        return delimeter;
    }

    /* 
        TODO: пофиксить невоможность спарсить числа в экспоненциальном виде типа 7.89E-4
        TODO: пофиксить проблему при смене знака второго числа, если оператором служит "-"
    */
    public void parse(String calculationText) {
        ParserUtils parserUtils = new ParserUtils();
        for (int i = 0; i < calculationText.length(); ++i) {
            if (calculationText.charAt(i) == '-' && i == 0) continue;
            if (parserUtils.isOperator(calculationText.charAt(i))) {
                delimeter = calculationText.charAt(i);
                break;
            }   
        }
        if (delimeter == 0) numbers[0] = Double.parseDouble(calculationText);
        else {
            String[] numbersLine = calculationText.split("\\" + delimeter);
            numbers[0] = Double.parseDouble(numbersLine[0]);
            if (numbersLine.length > 1) numbers[1] = Double.parseDouble(numbersLine[1]);
        }
    }
}
