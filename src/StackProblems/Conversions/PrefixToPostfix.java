package StackProblems.Conversions;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String exp = "-/A+BC*DE";
        System.out.println(convertPreToPos(exp,exp.length()));
    }

    private static String convertPreToPos(String exp, int length) {
        Stack<String> stack = new Stack<>();
        int i = length-1;
        while(i>=0)
        {
            char ch = exp.charAt(i--);
            if(Character.isLetter(ch)){
                stack.push(ch+"");
            }
            else{
                String e1 = stack.pop();
                String e2 = stack.pop();
                stack.push(e1+e2+ch);
            }
        }
        return stack.peek();
    }
}
