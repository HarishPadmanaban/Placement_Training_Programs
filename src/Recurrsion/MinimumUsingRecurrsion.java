package Recurrsion;

public class MinimumUsingRecurrsion {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,-12};
        //System.out.println(Min(arr,0));
        char ch = 'a';
        String str = "aabaabbaabacc";
        //System.out.println(str.substring(0,str.length()-1));
        //System.out.println(Character.getNumericValue(ch));
        System.out.println(Remove(str,""));

    }
    static int Min(int arr[],int n)
    {
        if(n==arr.length)
            return Integer.MAX_VALUE;
        return Math.min(arr[n],Min(arr,n+1));
    }
    static boolean ValidParantheses(String s,String p)
    {

        if(s.isEmpty())
        {
            return true&&p.isEmpty();
        }
        char c = s.charAt(0);
        if(c=='('||c=='{'||c=='[')
        {
            return ValidParantheses(s.substring(1),p+c);
        }
        boolean n = (c==')'&&p.charAt(p.length()-1)=='(')||(c=='}'&&p.charAt(p.length()-1)=='{')||(c==']'&&p.charAt(p.length()-1)=='[');
        return n && ValidParantheses(s.substring(1),p.substring(0,p.length()-1));
    }
    static String Remove(String s,String p)
    {
        if(p.isEmpty())
        {
            p+=s.charAt(0);
            s=s.substring(1);
        }
        if(s.isEmpty())
            return p;
        char c = s.charAt(0);
        if(c!=p.charAt(p.length()-1))
            return Remove(s.substring(1),p+c);
        return Remove(s.substring(1),p);
    }
}
