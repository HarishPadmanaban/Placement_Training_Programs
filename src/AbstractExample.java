public class AbstractExample {
    public static void main(String[] args) {
        //Person obj1 = new Person();
        //Employee2 obj2 = new Employee2();
        Employee3 obj3 = new Employee3("Harish","dummydob",20,20000);
        obj3.printAll();
        obj3.summa();
    }
}


abstract class Person{
    private String name;
    private String dob;
    private int age;
    public Person(String name, String dob, int age) {
        this.name = name;
        this.dob = dob;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printAll()
    {
        System.out.println(name+" "+age+" "+dob);
    }

    public abstract void summa();
}
abstract class Employee2 extends Person {
    private double salary;
    public Employee2(String name, String dob, int age, double salary) {
        super(name, dob, age);
        this.salary = salary;
    }
    abstract double salaryMethod(double salary);
}

class Employee3 extends Employee2{
    public Employee3(String name, String dob, int age, double salary) {
        super(name, dob, age, salary);
    }
    public double salaryMethod(double salary)
    {
        return salary/12.0;
    }
    public void summa()
    {
        System.out.println("Summa Summa");
    }
}