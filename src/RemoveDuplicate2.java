import java.util.*;

public class RemoveDuplicate2 {
    public static void main(String[] args) {
        int nums[] = {4,1,1,3,1,1,1,2,5,2};
        System.out.println(minSizeSubArray(nums,7));
        //leapYear(2100);
        //validParanthesis2("[]{}()");
        //frequencyArrangement(nums);
        //remove(nums);
    }
    public static int remove(int nums[])
    {
        int k = 2;

        for (int i = 2; i <nums.length ; i++) {
            if(nums[i]!= nums[k-2])
            {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static int minSizeSubArray(int nums[],int target)
    {
        int i=0;
        int curr = 0;
        int size = Integer.MAX_VALUE;
        for (int k = 0; k <nums.length ; k++) {
            curr+=nums[k];
            while(curr>=target)
            {
                size = Math.min(size,k-i+1);
                curr -= nums[i++];
            }
        }
        return size;
    }
    public static void leapYear(int year)
    {
        if((year%100!=0 || year %400==0)&&(year%4==0))
            System.out.println("Leap Year");
        else
            System.out.println("Not Leap Year");
    }

    public static void validParanthesis(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray())
        {
            if( c=='{' || c=='(' || c=='[')
                st.push(c);
            else{
                if(!st.isEmpty())
                {
                    char val = st.pop();
                    if((val=='(' && c!=')')||(val=='[' && c!=']')||(val=='{' && c!='}'))
                    {
                        System.out.println("Not valid");
                        return;
                    }
                }
                else{
                    System.out.println("Not valid");
                    return;
                }
            }
        }
        System.out.println(st.isEmpty() ? "Valid":"Not valid");
    }

    public static void validParanthesis2(String s)
    {
        char []ch = new char[s.length()];
        int i=0;
        for(char c : s.toCharArray())
        {
            if( c=='{' || c=='(' || c=='[')
                ch[i++] = c;
            else{
                if(i>0 && ((ch[i-1]=='(' && c==')')||(ch[i-1]=='[' && c==']')||(ch[i-1]=='{' && c=='}')))
                    i--;
                else {
                    System.out.println("Not valid");
                    return;
                }
            }
        }
        System.out.println(i==0 ? "Valid":"Not valid");
    }

    public static void frequencyArrangement(int nums[])
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int n : nums)
        {
            if(!hm.containsKey(n)) hm.put(n,1);
            else {
                int val = hm.get(n);
                val++;
                hm.put(n,val);
            }
        }
        System.out.println(hm);
    }
}
