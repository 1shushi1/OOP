package task7;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calc {
    private Map<String, BinaryOperator<BigDecimal>> operatorMap = new HashMap<>();
    public String doCalc(String cmd) {
        String result = "";

        return result;
    }
    public String addition(int number1, String op, int number2){
        operatorMap.put(op, BigDecimal :: add);
        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);
        BigDecimal sum = num1.add(num2);
        return String.valueOf(sum);
    }
    public String subtraction(int number1, String op, int number2){
        operatorMap.put(op, BigDecimal :: subtract);
        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);
        BigDecimal sum = num1.subtract(num2);
        return String.valueOf(sum);
    }
    public String multiplication(int number1, String op, int number2){
        operatorMap.put(op, BigDecimal :: subtract);
        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);
        BigDecimal sum = num1.multiply(num2);
        return String.valueOf(sum);
    }
    public String division(int number1, String op, int number2){
        operatorMap.put(op, BigDecimal :: subtract);
        BigDecimal num1 = new BigDecimal(number1);
        BigDecimal num2 = new BigDecimal(number2);
        BigDecimal sum = num1.divide(num2);
        return String.valueOf(sum);
    }
}
