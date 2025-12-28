import java.util.*;
interface Employee
{
    int count = 10;
    void personalData(String name,int age);
    double avgSalary(double Salary);
}

interface Worker{
    double netpay(double salary);
}


class Implementation implements Employee,Worker{

    public void personalData(String name,int age)
    {
        //count = 25;
        System.out.println(name+" "+age);
    }

    public double avgSalary(double salary){
        return salary/12.0;
    }

    public double netpay(double salary)
    {
        return salary*2;
    }
}

public class InterfaceExample {
    public static void main(String []args)
    {
        Implementation obj1 = new Implementation();
        System.out.println(obj1.avgSalary(12000));
        System.out.println(obj1.netpay(12000));
        obj1.personalData("harish",20);
    }
}



