package StackProblems;

import java.util.Arrays;
import java.util.Stack;


public class SumOfSubArrayMinimum {
    public static void main(String[] args) {
        int [] arr = {1,4,6,7,3,7,8,1}; // 3,1,2,4
        // 1,4,6,7,3,7,8,1
        // 11,81,94,43,3
        System.out.println(giveSum(arr));
        //System.out.println(Arrays.toString(giveNSE(arr)));
        //System.out.println(Arrays.toString(givePSEE(arr)));
        System.out.println(stackSolution(arr));
    }

    public static int stackSolution(int[] arr) {
        int[] pse = givePSEE(arr);
        int[] nge = giveNSE(arr);
        int mod = (int)Math.pow(10,9)+7;
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i-pse[i];
            int right = nge[i] - i;
            total = (total+(left*right*arr[i])%mod)%mod;
        }
        return total;
    }

    private static int giveSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            int min = arr[i];
            sum += min;
            for (int j = i+1; j <n ; j++) {
                min = Math.min(min,arr[j]);
                sum += min;
            }
        }
        return (int)(sum%(Math.pow(10,9)+7));
    }

    public static int[] giveNSE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[arr.length];
        for (int i = arr.length-1; i >=0 ; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] givePSEE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[]  res = new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            int curr = arr[i];
                while(!stack.isEmpty() && curr<arr[stack.peek()]){
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


//private static long giveSumofSubArrayMax(int[] arr) {
//        int[] pse = givePGEE(arr);
//        int[] nge = giveNGE(arr);
//        //int mod = (int)Math.pow(10,9)+7;
//        long total = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int left = i-pse[i];
//            int right = nge[i] - i;
//            total += (left*right*1L*arr[i]);
//        }
//        return total;
//    }
//
//    public static int[] giveNGE(int[] arr){
//        Stack<Integer> stack = new Stack<>();
//        int[]  res = new int[arr.length];
//        for (int i = arr.length-1; i >=0 ; i--) {
//            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
//                stack.pop();
//            }
//            res[i] = stack.isEmpty() ? arr.length : stack.peek();
//            stack.push(i);
//        }
//        return res;
//    }
//
//    public static int[] givePGEE(int[] arr) {
//        Stack<Integer> stack = new Stack<>();
//        int[]  res = new int[arr.length];
//        for (int i = 0; i <arr.length ; i++) {
//            int curr = arr[i];
//            while(!stack.isEmpty() && curr>arr[stack.peek()]){
//                stack.pop();
//            }
//            if(stack.isEmpty()){
//                res[i] = -1;
//            }
//            else{
//                res[i] = stack.peek();
//            }
//
//            stack.push(i);
//        }
//        return res;
//    }
//
//    public static long stackSolution(int[] arr) {
//        int[] pse = givePSEE(arr);
//        int[] nge = giveNSE(arr);
//        long total = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int left = i-pse[i];
//            int right = nge[i] - i;
//            total = (total+(left*right*1L*arr[i]));
//        }
//        return total;
//    }
//
//    public static int[] giveNSE(int[] arr){
//        Stack<Integer> stack = new Stack<>();
//        int[]  res = new int[arr.length];
//        for (int i = arr.length-1; i >=0 ; i--) {
//            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
//                stack.pop();
//            }
//            res[i] = stack.isEmpty() ? arr.length : stack.peek();
//            stack.push(i);
//        }
//        return res;
//    }
//
//    public static int[] givePSEE(int[] arr) {
//        Stack<Integer> stack = new Stack<>();
//        int[]  res = new int[arr.length];
//        for (int i = 0; i <arr.length ; i++) {
//            int curr = arr[i];
//                while(!stack.isEmpty() && curr<arr[stack.peek()]){
//                    stack.pop();
//                }
//                if(stack.isEmpty()){
//                    res[i] = -1;
//                }
//                else{
//                    res[i] = stack.peek();
//                }
//
//            stack.push(i);
//        }
//        return res;
//    }

// long largest = giveSumofSubArrayMax(arr);
//        long smallest = stackSolution(arr);
//        //System.out.println(largest-smallest);
//        return (long)(largest-smallest);