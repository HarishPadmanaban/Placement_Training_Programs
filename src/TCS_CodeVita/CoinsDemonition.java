package TCS_CodeVita;

public class CoinsDemonition {
    public static void main(String[] args) {
        int n = 11;
        minCoins(n);
    }

    private static void minCoins(int n) {
        int remaining = n-4;
        if(remaining<0)
        {
            calculate(n,0);
            return;
        }
        int rs5 = remaining/5;
        remaining = 4+(remaining%5);
        calculate(remaining,rs5);
    }

    private static void calculate(int remaining,int rs5) {
        int rs2=0;
        int rs1=0;
        if(remaining%2==0)
        {
            rs1+=2;
            remaining-=2;
        }
        else{
            rs1+=1;
            remaining-=1;
        }
        rs2 = remaining/2;
        System.out.println((rs5+rs1+rs2)+ "=>"+rs5+" "+rs2+" "+rs1);
    }
}
