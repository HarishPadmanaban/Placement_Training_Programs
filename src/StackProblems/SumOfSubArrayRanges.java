package StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayRanges {
    public static void main(String[] args) {
        // Largest - Smallest
        int [] arr = {1,4,3,2};
        //System.out.println(Arrays.toString(giveNGE(arr)));
        //System.out.println(Arrays.toString(givePGEE(arr)));
        int largest = giveSumofSubArrayMax(arr);
        int smallest = SumOfSubArrayMinimum.stackSolution(arr);
        System.out.println(largest-smallest);
    }

    private static int giveSumofSubArrayMax(int[] arr) {
        int[] pse = givePGEE(arr);
        int[] nge = giveNGE(arr);
        int mod = (int)Math.pow(10,9)+7;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i-pse[i];
            int right = nge[i] - i;
            total = (total+(left*right*arr[i])%mod)%mod;
        }
        return total;
    }

    public static int[] giveNGE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] givePGEE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            int curr = arr[i];
            while(!stack.isEmpty() && curr>arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = stack.peek();
            }

            stack.push(i);
        }
        return res;
    }
}
