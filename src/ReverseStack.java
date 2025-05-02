import java.util.*;
class Queue
{
    class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public Node front;
    public Node rear;
    public void insert(int s)
    {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the data :");
//        int s = sc.nextInt();
        Node newNode = new Node(s);
        if(front==null)
        {
            front=newNode;
            rear=newNode;
        }
        else{
            rear.next = newNode;
            rear=newNode;
        }
        System.out.println("Inserted into queue :"+newNode.data);
    }
    public void delete()
    {
        if(front==null)
        {
            System.out.println("Empty queue");
            return;
        }
        else if(front==rear)
        {
            System.out.println("Deleted the node :"+rear.data);
            rear=front=null;
            return;
        }
        else{
            System.out.println("Deleted the node :"+front.data);
            Node t = front;
            front=front.next;
            t=null;
        }
    }
    public void display()
    {
        Node t = front;
        if(t==null)
        {
            System.out.println("Empty");
            return;
        }
        while(t!=null)
        {
            System.out.println(t.data);
            t=t.next;
        }
    }
}
public class ReverseStack {
    class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    int top=-1;
    public Node head;
    public void push(int s)
    {

//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the data :");
//        int s = sc.nextInt();
        Node newNode = new Node(s);
            //Checks if the list is empty
            if(head == null) {
                head = newNode;
            }
            else {
                //newNode will be added after tail such that tail's next will point to newNode
                newNode.next=head;
                head = newNode;
            }
        System.out.println("LinkedList.Node inserted:"+newNode.data);
            top++;
    }
    public int pop()
    {
        if(head==null)
        {
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            Node t = head;
            head = head.next;
            System.out.println("LinkedList.Node deleted : "+t.data);
            return t.data;
        }
    }
    public void display()
    {
        Node t = head;
        if(t==null)
        {
            System.out.println("Empty");
            return;
        }
        while(t!=null)
        {
            System.out.println(t.data);
            t=t.next;
        }
    }
    public int peek()
    {
        if(head!=null)
            return head.data;
        return -1;
    }
    public static void main(String args[])
    {
        Queue q = new Queue();
        ReverseStack r = new ReverseStack();
        ReverseStack r2 = new ReverseStack();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do {

            System.out.print("1.Push\t2.Pop\t3.display\t4.peek\t5.Exit\nEnter any value :");
            int n = sc.nextInt();
            switch (n) {
                case 1:

                    System.out.print("Enter the data :");
                    int s = sc.nextInt();
                    r.push(s);
                    break;
                case 2:
                    r.pop();
                    break;
                case 3:
                    r.display();
                    break;
                case 4:
                    System.out.println(r.peek());
                    break;
                case 5:
                    flag=false;
                    break;
            }
        }while(flag);
        //ReverseStack.LinkedList.Node t = r.head;
        int c = r.pop();
        while(c != -1)
        {
            q.insert(c);
            c = r.pop();
        }
        Queue.Node t1 =q.front;

        while(t1!=null)
        {
            r.push(t1.data);
            t1=t1.next;
        }
        System.out.println("Queue Values:");
        q.display();
        System.out.println("Stack values after reverse Values:");
        r.display();
    }

}
