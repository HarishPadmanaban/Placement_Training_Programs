package StackProblems.Conversions;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        //((a-b)/((c-d)+e)) op:/-ab+-cde
        String exp = "((a-b)/((c-d)+e))";
        System.out.println(givePrefix(exp,exp.length()));
    }

    private static String givePrefix(String exp, int length) {
        int i = 0;
        Stack<String> stack = new Stack<>();
        String postfix = "";
        while(i<length){
            char c = exp.charAt(i++);
            if(c!=')')
            {
                if(c=='(') continue;
                stack.push(c+"");
            }
            else {
                String e1 = stack.pop();
                String op = stack.pop();
                String e2 = stack.pop();
                String s1 = op+e2+e1;
                stack.push(s1);
            }
        }
        System.out.println(stack);
        return stack.peek();
    }
}
