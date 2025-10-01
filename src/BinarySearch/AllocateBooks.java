package BinarySearch;

import java.util.ArrayList;

public class AllocateBooks {
    public static void main(String[] args) {

    }
        public static int findPages(ArrayList<Integer> arr, int n, int m) {
            int min = -1;
            int l = -1;
            int r = 0;
            for(int num : arr){
                l = Math.max(l,num);
                r += num;
            }
            //System.out.println(l+" "+r);
            if(m==1) return r;
            if(n<m) return -1;
            while(l<=r)
            {
                int mid = l +(r-l)/2;
                int student = findSatisfied(arr,n,m,mid);
                if(student<=m){
                    min = mid;
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            return min;
        }

        private static int findSatisfied(ArrayList<Integer> arr, int n, int m,int mid)
        {
            int pages = 0;
            int student = 1;
            for(int num : arr)
            {
                if(pages+num>mid)
                {
                    student++;
                    pages = num;
                }
                else{
                    pages = pages + num;
                }
            }
            return student;
        }

}
