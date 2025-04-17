import java.util.*;
interface Employee
{
    void personalData(String mobile,String doj);
    void salaryData(float bp);
}
class ImplementationClass implements Employee
{
    int id;
    String name;
    String dept;

    public ImplementationClass(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }
    public void personalData(String mobile,String doj)
    {
        System.out.println("Name:"+name+"\nID:"+id+"\nDepartment:"+dept+"\nMobile:"+mobile+"\nDate of joining:"+doj);
    }
    public void salaryData(float bp)
    {
        float da = ((15/bp)*100);
        float hra = (15/bp)*100;
        float ma = (15/bp)*100;
        float ta = da+hra+ma;
        float pf = (12/bp)*100;
        float mi = (12/bp)*100;
        float td = pf+mi;
        float grosspay = bp+ta;
        float netpay = grosspay-td;
        System.out.println("GrossPay:"+grosspay);
        System.out.println("NetPay:"+netpay);
    }


}
public class InterfaceExample {
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Id :");
        int id = sc.nextInt();
        System.out.println("Enter Employee Name :");
        String name = sc.next();
        System.out.println("Enter Employee Department :");
        String depart = sc.next();
        System.out.println("Enter Employee mobile :");
        String mobile = sc.next();
        System.out.println("Enter Employee Date of Joining :");
        String doj = sc.next();
        System.out.println("Enter Employee salary :");
        float salary = sc.nextFloat();
        ImplementationClass obj = new ImplementationClass(id,name,depart);
        obj.personalData(mobile, doj);
        obj.salaryData(salary);
    }
}
