package TCS_CodeVita;

import java.util.Stack;

public class DivineDivisors {
    public static void main(String[] args) {
        int n = 36;
        divisor(n);

    }

    private static void divisor(int n) {
        Stack<Integer> s = new Stack<>();
        System.out.print("1\t");
        s.push(n);
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0){
                System.out.print(i+"\t");
                if(i*i!=n) s.push(n/i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+"\t");
        }
    }

}
