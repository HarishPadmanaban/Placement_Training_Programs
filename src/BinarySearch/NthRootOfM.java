package BinarySearch;

public class NthRootOfM {
    public static void main(String[] args) {
        System.out.println(sqrtN(69,4));
    }

    public static int sqrtN(long N,int m) {
        long s = 1;
        long e = N;
        while(s<=e)
        {
            long mid = s+(e-s)/2;
            long val = (long)Math.pow(mid,m);
            //val = Math.pow(mid,2);
            if(val==N) return (int)mid;
            else if(val>N) e = mid-1;
            else s = mid+1;
        }
        return -1;
    }
}
