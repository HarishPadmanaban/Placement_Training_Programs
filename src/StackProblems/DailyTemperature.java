package StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int [] arr = {89,62,70,58,47,47,46,76,100,70};
                //{30,60,90};
                //{73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(giveTemp(arr)));
    }

    private static int[] giveTemp(int[] arr) {
        int i = arr.length-1;
        int [] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        while(i>=0)
        {
            if(stack.isEmpty()){
                res[i] = 0;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = 0;
                }
                else{
                    res[i] = stack.peek() - i;
                }
                stack.push(i);
            }
            i--;
        }
        return  res;
    }
}
