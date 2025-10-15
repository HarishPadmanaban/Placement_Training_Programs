package StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class VisiblePeopleInQueue {
    public static void main(String[] args) {
        int [] arr = {5,1,2,3,10};
        System.out.println(Arrays.toString(giveCount(arr)));
    }

    private static int[] giveCount(int[] arr) {
        int i = arr.length-1;
        int [] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        while(i>=0)
        {
            if(stack.isEmpty()){
                res[i] = 0;
                stack.push(arr[i]);
            }
            else{
                int val = 0;
                while(!stack.isEmpty() && arr[i]>=stack.peek()){
                    stack.pop();
                    val++;
                }
                if(stack.isEmpty()){
                    res[i] = val;
                }
                else if(stack.peek()>arr[i]){
                    val++;
                    res[i] = val;
                }
                stack.push(arr[i]);
            }
            i--;
        }
        return  res;
    }
}
