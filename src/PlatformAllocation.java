import java.lang.reflect.Array;
import java.util.*;
import java.util.Queue;

public class PlatformAllocation {
    public static void main(String[] args) {
        int arrival[] = {900,940,1050,1125,1500,1800};
        int departure[] = {910,1030,1120,1130,1800,2000};
        System.out.println(numberOfPlatforms(arrival,departure));
    }

    private static int numberOfPlatforms(int[] arrival, int[] departure) {
        int max = -1;
        //Queue<Integer> depart = new LinkedList<>();
        List<Integer> depart = new ArrayList<>();

        for (int i = 0; i < arrival.length; i++) {
            int arrive = arrival[i];
            int d = departure[i];
            if(depart.isEmpty()){
                depart.add(d);
                max = Math.max(max,depart.size());
                continue;
            }
            Collections.sort(depart);
            int lastD = depart.get(0);
            if(arrive<lastD){
                depart.add(d);
                max = Math.max(max,depart.size());
                continue;
            }
            while(arrive>lastD && !depart.isEmpty())
            {
                lastD = depart.removeFirst();
            }
            depart.add(d);
        }
        return max;
    }
}
