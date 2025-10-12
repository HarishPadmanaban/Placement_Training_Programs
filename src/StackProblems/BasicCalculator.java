package StackProblems;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String exp = "1-(     -2)";
        exp = exp.replace(" ","");
        System.out.println(evaluateExp(exp));
    }

    private static int evaluateExp(String exp) {
        //int res = 0;
        if(exp.charAt(0)=='-' || exp.charAt(0)=='+') exp = "0"+exp;
        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if(Character.isWhitespace(ch)) continue;
            if(Character.isDigit(ch)){
                int num = 0;
                while(i<exp.length() && Character.isDigit(exp.charAt(i))){
                    num = num*10+(exp.charAt(i)-'0');
                    i++;
                }
                i--;
                numbers.push(num);
            }
            else if(ch=='('){
                operators.push(ch);
                if(exp.charAt(i+1)=='-') numbers.push(0);
            }
            else if(ch==')'){
                while(operators.peek()!='('){
                    numbers.push(computeValue(numbers.pop(),operators.pop(),numbers.pop()));
                }
                operators.pop();
            }
            else if(ch=='+' || ch=='-'){
                while(!operators.isEmpty() && precedence(ch)<=precedence(operators.peek())){
                    numbers.push(computeValue(numbers.pop(),operators.pop(),numbers.pop()));
                }
                operators.push(ch);
            }
        }
        //System.out.println(numbers);
        //System.out.println(operators);
        while(!operators.isEmpty()){
            numbers.push(computeValue(numbers.pop(),operators.pop(),numbers.pop()));
        }
        return numbers.peek();
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static int computeValue(Integer val2, Character op, Integer val1) {
        int res = 0;
        switch (op){
            case '+':
                res = val1+val2;
                break;
            case '-':
                res = val1-val2;
                break;
        }
        return res;
    }
}
