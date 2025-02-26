package controller.parsers;

public class ParserCalculationField {
    private double[] numbers;
    private final int COUNT_NUMBERS = 2;
    private char delimeter;

    public ParserCalculationField(){
        numbers = new double[COUNT_NUMBERS];
        delimeter = ' ';
    }

    public double[] getNumbers(){
        return numbers;
    }

    public char getDelimeter(){
        return delimeter;
    }

    private boolean getOperator(char delimeter){
        return delimeter == '+' || delimeter == '-' || delimeter == '/' || delimeter == '*'; 
    }

    // TODO: пофиксить невоможность спарсить числа в экспоненциальном виде типа 7.89E-4
    public void parse(String calculationText){
        for (int i = 0; i < calculationText.length(); ++i){
            if (getOperator(calculationText.charAt(i)))
                delimeter = calculationText.charAt(i);
        } 
        String[] numbersLine = new String[COUNT_NUMBERS];
        if (delimeter == ' '){
            numbersLine[0] = "0";
            numbersLine[1] = calculationText;
        }
        else numbersLine = calculationText.split("" + delimeter); 
        for (int i = 0; i < COUNT_NUMBERS; ++i){
            numbers[i] = Double.parseDouble(numbersLine[i]);
        }
    }
}
