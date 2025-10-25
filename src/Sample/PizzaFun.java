package Sample;

import java.util.Scanner;

public class PizzaFun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if(s.equals("1/4")){
                total += 0.25;
            }
            else if(s.equals("1/2")){
                total += 0.5;
            }
            else if(s.equals("3/4")){
                total += 0.75;
            }
        }
        System.out.println((int)Math.ceil(total+1));
    }
}
