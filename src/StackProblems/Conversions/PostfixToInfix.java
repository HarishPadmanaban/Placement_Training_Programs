package StackProblems.Conversions;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String exp = "ABC/DA-*+";
        System.out.println(giveInfix(exp,exp.length()));
    }

    private static String giveInfix(String exp, int length) {
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
                stack.push("("+e2+ch+e1+")");
            }
        }
        return stack.peek();
    }
}
