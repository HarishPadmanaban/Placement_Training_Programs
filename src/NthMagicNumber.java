public class NthMagicNumber {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        int base = 5;
        while(n>0)
        {
            sum+= (n&1)*(base);
            base*=5;
            n>>=1;
        }
        System.out.println(sum);
        DectoBin(5);
        lengthOfBase(10,2);
    }

    public static void DectoBin(int n)
    {
        String res ="";
        while(n>0)
        {
            res = (n%2+res);
            n/=2;
        }
        System.out.println(res);
    }
    public static void lengthOfBase(int a,int b)
    {
        int len = (int)(Math.log(a)/Math.log(b))+1;
        System.out.println(len);
    }
}
