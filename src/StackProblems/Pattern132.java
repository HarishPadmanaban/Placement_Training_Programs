package StackProblems;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int [] nums = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,18};
        // 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,18
        System.out.println(isPattern(nums));
    }

    private static boolean isPattern(int[] nums)
    {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]<second){
                return true;
            }
            while(!st.isEmpty() && nums[i] > st.peek()){
                second = st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}
