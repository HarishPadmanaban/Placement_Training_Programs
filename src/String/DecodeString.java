package String;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String a = "2[abc]3[cd]ef";
        //2[abc]3[cd]ef
        //2[a]3[bc]
        //System.out.println(decode(a));
        System.out.println(decodeAgain(a));
    }

    private static String decodeAgain(String s) {
        Stack<Character> charStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String res = "";
        String num = "";
        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)))
            {
                num+=(s.charAt(i)+"");
            }else{
                if(!num.equals("")){
                    numStack.push(Integer.parseInt(num));
                    num="";
                }
                if(s.charAt(i)==']')
                {
                    String curr="";
                    while(charStack.getLast()!='['){
                        char c = charStack.pop();
                        curr += (c+"");
                    }
//                    int j = i+1;
//                    while(j<s.length()){
//                        if(s.charAt(j)!=']')
//                            curr+=(s.charAt(j)+"");
//                        j++;
//                    }
                    //curr = new StringBuffer(curr).reverse().toString();
                    res = (curr)+res;
                    res = res.repeat(numStack.pop());
                    charStack.pop();
                }
                else{
                    charStack.push(s.charAt(i));
                }
            }
        }
        //System.out.println(charStack.getFirst()+" "+charStack.getLast());
        System.out.println(numStack);
        System.out.println(charStack);
        return new StringBuffer(res).reverse().toString();
    }

    private static String decode(String a) {
        //Stack<String> s = new Stack<>();
        String num = "";
        String res = "";
        int i =0;
        while(i<a.length())
        {
            if(a.charAt(i)!='[')
            {
                num+=(a.charAt(i)+"");
            }
            else{
                int times = Integer.parseInt(num);
                int j = i+1;
                String curr = "";
                while(a.charAt(j)!=']')
                {
                    curr+=(a.charAt(j)+"");
                    j++;
                }
                res+=(curr.repeat(times));
                i=j;
                num="";
            }
            i++;
        }
        return res;
    }


}
