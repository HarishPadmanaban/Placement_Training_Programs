package StackProblems.Conversions;

import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) {
        String exp = "a+b+c+d-e"; //op : ABC/DA-*+
        System.out.println(givePostfix(exp,exp.length()));
        // This code fails for : A*B+C (type of testcases) need modification
        //System.out.println(giveCorrectPostfix(exp,exp.length()));
    }

//    private static String giveCorrectPostfix(String exp, int length) {
//
//    }

    private static String givePostfix(String exp, int length) {
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
                String s1 = e2 + e1 + op;
                stack.push(s1);
            }
        }
        while(stack.size()>1){
            String e1 = stack.pop();
            String op = stack.pop();
            String e2 = stack.pop();
            String s1 = e2 + e1 + op;
            stack.push(s1);
        }
        return stack.peek();
    }
}
