package StackProblems;

import java.util.Stack;

public class RemoveKDigit {
    public static void main(String[] args) {
        String num = "123";
        StringBuffer str = new StringBuffer(num);
        str = str.reverse();
        System.out.println(str.lastIndexOf("3"));
        int k = 3;
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray())
        {

        }
    }
}
