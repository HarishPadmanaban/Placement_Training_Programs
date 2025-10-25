package StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int arr[] = {1,8,3,4,1,6,10,12};
        System.out.println(Arrays.toString(givePSE(arr)));
    }

    private static int[] givePSE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            int curr = arr[i];
            if(stack.isEmpty())
            {
                res[i] = -1;
            }
            else{
                while(!stack.isEmpty() && curr<stack.peek()){
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
        return res;
    }
}
