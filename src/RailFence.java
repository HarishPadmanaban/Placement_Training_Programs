import java.util.*;

public class RailFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pt = sc.nextLine();
        int d = sc.nextInt();
        List<List<Character>> li = encrypt(pt,d);
        System.out.println();
        decrypt(li,d);
    }
    public static List<List<Character>> encrypt(String pt,int d)
    {
        List<List<Character>> li = new ArrayList<>();
        for(int i=0;i<d;i++)
        {
            List<Character> r = new ArrayList<>();
            for (int k = i; k < pt.length(); k+=d) {
                r.add(pt.charAt(k));
                System.out.print(pt.charAt(k));
            }
            li.add(r);
        }
        return li;
    }
    public static void decrypt(List<List<Character>> li , int d)
    {
        int j=0;
        for(int i=0;i<d;i++) {
            for (List<Character> l : li) {
                if(j<l.size())
                    System.out.print(l.get(j));
            }
            j++;
        }
        for(List<Character> l :li)
        {
            if(j<l.size())
                System.out.print(l.get(j));
        }
    }

}
