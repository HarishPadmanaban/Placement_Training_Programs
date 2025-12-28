package Sample;
import java.util.HashMap;

public class Dobuloon {
    public static void main(String[] args) {
        String s = "abbac";
        //List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
        {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        //System.out.println(map);
        for (char ch : map.keySet())
        {
            if(map.get(ch)!=2){
                System.out.println("Not dobuloon");
                return;
            }
        }
        System.out.println("It is Dobuloon");
    }
}
