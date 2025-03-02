package controller.parsers.utils;

public class ParserUtils {
    public boolean isOperator(char delimeter){
        return delimeter == '+' || delimeter == '-' || delimeter == '/' || delimeter == '*';
    }

    public char getOperator(int positionX){
        char[] operators = {'/', '*', '-', '+'};
        return operators[positionX - 1];
    }
}
