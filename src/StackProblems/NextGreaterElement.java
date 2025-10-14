package StackProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {1,5,3,4,3};
        int res[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //HashMap<Integer,Integer> map = new HashMap<>();
        giveNextGreater(arr,res,stack);
        System.out.println(Arrays.toString(res)+"\n"+stack);
        giveNextGreater(arr,res,stack);
        System.out.println(Arrays.toString(res)+"\n"+stack);
    }

    private static void giveNextGreater(int[] arr, int[] res, Stack<Integer> stack) {
        for (int i = arr.length-1; i >=0 ; i--) {
            int curr = arr[i];
            if(stack.isEmpty())
            {
                res[i] = -1;
            }
            else{
                while(!stack.isEmpty() && curr>=stack.peek()){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = -1;
                }
                else{
                    res[i] = stack.peek();
                }
            }
            stack.push(curr);
        }
    }
}
