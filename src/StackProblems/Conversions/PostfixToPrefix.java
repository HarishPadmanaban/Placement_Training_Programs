package StackProblems.Conversions;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String exp = "ab+cd-*";
        System.out.println(convertPosToPre(exp,exp.length()));
    }

    private static String convertPosToPre(String exp, int length) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i<length)
        {
            char ch = exp.charAt(i++);
            if(Character.isLetter(ch)){
                stack.push(ch+"");
            }
            else{
                String e1 = stack.pop();
                String e2 = stack.pop();
                stack.push(ch+e2+e1);
            }
        }
        return stack.peek();
    }
}
