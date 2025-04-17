public class recurrsion {
    static int rev =0;
    public static void main(String args[])
    {
        int f = 123;
        int len = (int)Math.log10((double)f)+1;
        //System.out.println(len);
        //System.out.println(fibo(5));
        reverse(f);
        System.out.println(rev);
    }
    static int fibo(int n)
    {
        if(n<=1)
            return n;
        return fibo(n-1)+fibo(n-2);
    }
    static void reverse(int n)
    {
        if(n<=0)
            return;
        rev = (rev*10)+n%10;
        reverse(n/10);
    }
}
