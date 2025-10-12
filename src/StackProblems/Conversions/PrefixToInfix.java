package StackProblems.Conversions;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String exp = "*-a/bc-/dkl";
        System.out.println(giveInfix(exp,exp.length()));
    }

    private static String giveInfix(String exp, int length) {
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
                stack.push("("+e1+ch+e2+")");
            }
        }
        return stack.peek();
    }
}
