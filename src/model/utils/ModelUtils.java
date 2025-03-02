package model.utils;

public class ModelUtils {
    private Double num1;
    private Double num2;
    private char delimeter;
    final public String ERROR_MESSAGE = "Неверный ввод!";

    public ModelUtils(){}

    public ModelUtils(Double num1, Double num2, char delimeter) {
        this.num1 = num1;
        this.num2 = num2;
        this.delimeter = delimeter;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public void setDelimeter(char delimeter) {
        this.delimeter = delimeter;
    }

    public Double getNum1() {
        return num1;
    }

    public Double getNum2() {
        return num2;
    }

    public char getDelimeter(){
        return delimeter;
    }

    // TODO: при необходимости изменить логику вычисления процента
    public String percent(){
        return (num2 == null) 
            ? "" + getAccurateValue(num1 / 100)
            : "" + getAccurateValue(num1) + delimeter + getAccurateValue(num2 / 100);
    }

    public String clear(){
        return "0";
    }

    public String clearEntry(){
        return (num2 == null) ?  "0" : "" + getAccurateValue(num1) + delimeter;
    }

    public String calculationSquare(){
        return (num2 == null)
        ? "" + getAccurateValue(num1*num1) 
        : "" + getAccurateValue(num1) + delimeter + getAccurateValue(num2*num2);
    }

    public String calculationDivideOneByNumber(){
        if (num2 == null)
            return (num1 == 0) 
                ? ERROR_MESSAGE 
                : "" + getAccurateValue(1 / num1);
        else
            return (num2 == 0) 
                ? ERROR_MESSAGE 
                : "" + getAccurateValue(num1) + delimeter + getAccurateValue(1 / num2);
    }

    public String calculationSquareRoot(){
        if (num2 == null)
            return (num1 < 0) 
                ? ERROR_MESSAGE 
                : "" + getAccurateValue(Math.sqrt(num1));
        else
            return (num2 < 0) 
                ? ERROR_MESSAGE 
                : "" + getAccurateValue(num1) + delimeter + getAccurateValue(Math.sqrt(num2));
    }

    public String calculate(char operator){
        return calculateByDelimeter(num1, (num2 == null) ? 0.0 : num2, delimeter) + operator;
    }

    public String changeSign() {
        if (num2 == null)
            return (num1 < 0) 
                ? "" + getAccurateValue(Math.abs(num1)) 
                : "-" + getAccurateValue(num1);
        else
            return (num2 < 0) 
                ? "" + getAccurateValue(num1) + delimeter + getAccurateValue(num2)
                : "" + getAccurateValue(num1) + delimeter + "-" + getAccurateValue(num2);
    }

    public String equals() {
        return calculateByDelimeter(num1, (num2 == null) ? 0.0 : num2, delimeter);
    }

    public String concatDelimeter() {
        if (num2 == null)
            return (hasDot(getAccurateValue(num1)) == -1)
                ? getAccurateValue(num1) + "." 
                : "" + getAccurateValue(num1);
        else 
            return (hasDot(getAccurateValue(num2)) == -1)
                ? getAccurateValue(num1) + delimeter + getAccurateValue(num2) + "." 
                : "" + getAccurateValue(num1) + delimeter + getAccurateValue(num2);
    }

    public String getAccurateValue(double num){
        return (num == (long) num) ? "" + (long) num : "" + num;
    }

    private String calculateByDelimeter(double num1, double num2, char delimeter){
        switch (delimeter){
            case '+':
                return getAccurateValue(num1 + num2);
            case '-':
                return getAccurateValue(num1 - num2);
            case '*':
                return getAccurateValue(num1 * num2);
            case '/':
                return getAccurateValue(num1 / num2);
            default:
                return getAccurateValue(num1);
        }
    }

    private int hasDot(String num){
        return num.indexOf('.');
    }
}