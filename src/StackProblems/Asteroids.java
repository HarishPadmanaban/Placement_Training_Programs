package StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class Asteroids {
    public static void main(String[] args) {
        int[] arr = {-2,1,-1,-2};
        System.out.println(Arrays.toString(giveFinalState(arr)));
        System.out.println(Arrays.toString(simplifiedSolution(arr)));
    }

    private static int[] simplifiedSolution(int[] arr) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : arr){
            boolean destroyed = false;

            while(!st.isEmpty() && st.peek()>0 && asteroid<0){
                if(st.peek()<-asteroid){
                    st.pop();
                    continue;
                }
                else if(st.peek()==-asteroid){
                    st.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed){
                st.push(asteroid);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }

    private static int[] giveFinalState(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        int direction = st.peek()>0 ? 1 : -1;
        int i = 1;
        while (i<arr.length) {
            if(direction==1 && arr[i]<0){
                boolean isCont = false;
                while(i<arr.length && !st.isEmpty() && direction==1 && arr[i]<0){
                    if(arr[i]==(st.peek()*-1)){
                        st.pop();
                        i++;
                        if(!st.isEmpty())   direction = st.peek() >0 ? 1:-1;
                        isCont = true;
                        continue;
                    }
                    else if((arr[i]*-1)>(st.peek())){
                        st.pop();
                    }
                    else{
                        i++;
                        isCont = true;
                        break;
                    }
                    if(!st.isEmpty())   direction = st.peek() >0 ? 1:-1;
                }
                if(isCont) continue;
                if(i<arr.length && (st.isEmpty() || (st.peek()<0 && arr[i]<0))){
                    st.push(arr[i]);
                    direction = arr[i] >0 ? 1:-1;
                }
            }
            else{
                st.push(arr[i]);
                direction = arr[i] >0 ? 1:-1;
            }
            i++;
        }
        //System.out.println(st);
        int res[] = new int[st.size()];
        int k = res.length-1;
        while(!st.isEmpty()) res[k--] = st.pop();
        return res;
    }
}
