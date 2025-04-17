class A
{
    int a = 10;
      void H1(){
        System.out.println("Hello from A");
    }
}

class B extends A
{
    int b = 20;
     void H1(){
        super.H1();
        System.out.println("Hello from B");
    }
}

class C extends A
{
    int c = 30;
    static void H3(){
        System.out.println("Hello from C");
    }
}

class D extends B
{
    int d = 40;
    static void H4(){
        System.out.println("Hello from D");
    }
}

class E extends D
{
    int e = 50;
    static void H5(){
        System.out.println("Hello from E");
    }
}

public class HybridExample {
    public static void main(String args[])
    {
        A obj1 = new A();
        //obj.H1();
        B obj2 = new B();
        C obj3 = new C();
        //A obj4 = new C();
//        obj4.H1();
//        obj4.H3();

        //System.out.println(obj2.a);

    }
}
