package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegative {
    public static void main(String[] args) {
        int[] arr = {-8,2,3,-6,10};
        int k = 2;
        System.out.println(firstNegInt(arr,k));
    }

    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> li = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0,j = 0,n = arr.length;
        while(j<n)
        {
            if(arr[j]<0) q.add(arr[j]);

            if(j-i+1 < k)
            {
                j++;
            }

            else if(j-i+1 == k)
            {
                if(q.isEmpty()) li.add(0);
                else li.add(q.peek());

                if(!q.isEmpty() && arr[i]==q.peek()) q.poll();
                i++;
                j++;
            }
        }
        return li;
    }
}
