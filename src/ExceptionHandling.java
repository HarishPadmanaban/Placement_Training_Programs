import java.util.*;
public class ExceptionHandling {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        String s = null;
        String s1= "Hello";
        try{
            //int i = Integer.parseInt("Helllo");
            //System.out.println(s.length());
            //System.out.println(s1.charAt(8));
            //System.out.println(arr[20]);
            int d = 10/0;
        }catch(NumberFormatException ne)
        {
            System.out.println("Wrong datatype conversion");
        }catch(NullPointerException e){
            System.out.println("For null String we can define the length");
        }catch(StringIndexOutOfBoundsException sieo){
            System.out.println(s1.charAt(0));
        }catch(ArrayIndexOutOfBoundsException are){
            System.out.println(are.getCause());
            System.out.println(are.getMessage());
            System.out.println(are.getStackTrace());
            System.out.println(arr[0]);
        }catch(ArithmeticException are) {
            System.out.println(are.getCause());
            System.out.println(are.getMessage());
            System.out.println(are.getStackTrace());
        }
//        }catch(Exception e)
//        {
//            System.out.println("Specific Exception si not defined");
//        }

        System.out.println("Thank you");
    }
}
