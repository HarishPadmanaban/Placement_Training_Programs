package LinkedList;

import java.util.Scanner;
class Node
{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyLinkedList {
    Node head;
    public void display()
    {
        if(head==null)
        {
            System.out.println("Nothing to print");
            return;
        }
        else{
            Node temp = head;
            if(temp.next==null){
                System.out.println(temp.data);
                return;
            }
            else{
                while(temp.next!=null)
                {
                    System.out.println(temp.data);
                    temp=temp.next;
                }
                System.out.println(temp.data);
            }
        }
    }
    public void insertatbegin()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to insert:");
        int val = sc.nextInt();
        Node n = new Node(val);
        if(head==null)
        {
            head=n;
            return;
        }
        n.next=head;
        head.prev=n;
        head = n;
        System.out.println("LinkedList.Node Inserted Successfully : "+val);
    }
    public void insertatend()
    {
        if(head==null)
        {
            insertatbegin();
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to insert:");
        int val = sc.nextInt();
        Node n = new Node(val);
        Node t = head;
        while(t.next!=null)
            t=t.next;
        t.next=n;
        n.prev=t;
        System.out.println("LinkedList.Node Inserted Successfully : "+val);
    }
    public void deleteatbegin()
    {
        if(head==null)
        {
            System.out.println("Nothing to delete.Empty List.");
            return;
        }
        else{
            Node temp = head;
            if(temp.next==null)
            {
                System.out.println("LinkedList.Node deleted:"+temp.data);
                head=null;
                return;
            }
            System.out.println("LinkedList.Node Deleted:"+head.data);
            head=head.next;
            head.prev=null;
            temp=null;
        }
    }
    public void deleteatend()
    {
        if(head==null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        else
        {
            Node temp = head;
            if(temp.next==head)
            {
                System.out.println("LinkedList.Node deleted:"+temp.data);
                head=null;
                return;
            }
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            System.out.println("LinkedList.Node Deleted:"+temp.data);
            temp.prev.next=null;
            temp.prev=null;
        }
    }
    public void KeySearch(int key)
    {
        Node t = head;
        if(t==null)
        {
            System.out.println("Empty List");
            return;
        }
        else if(t.next==null)
        {
            if(t.data==key)
                System.out.println("Data found:"+t.data);
            else
                System.out.println("Data not found");
            return;
        }
        if(key%2==0)
        {
            int c =0;
            while(t.next!=null)
            {
                if(c%2==0)
                {
                    if(t.data==key)
                    {
                        System.out.println("Data Found at Even Position:"+t.data);
                        return;
                    }
                }
                t=t.next;
                c++;
            }
            System.out.println("Data not found at Even Position");
        }
        else
        {
            int c =0;
            while(t.next!=null)
            {
                if(c%2!=0)
                {
                    if(t.data==key)
                    {
                        System.out.println("Data Found at odd position:"+t.data);
                        return;
                    }
                }
                t=t.next;
                c++;
            }
            System.out.println("Data not found at odd Position");
        }
    }
    public void insertAtMid(int pos)
    {
        int count = getCount();
        //System.out.println("Count of Nodes:"+count);
        if(pos<=0 || pos>count+1)
        {
            System.out.println("Enter a valid Position");
            return;
        }
        if(pos==1||head==null)
        {
            insertatbegin();
            return;
        }
        else if(pos==count+1)
        {
            insertatend();
            return;
        }
        else{

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter value to insert:");
            int val = sc.nextInt();
            Node b = new Node(val);
            Node t = head;
            for (int i = 1; i < pos-1&&t.next!=null; i++) {
                t = t.next;
            }
            t.next.prev=b;
            b.next=t.next;
            b.prev=t;
            t.next=b;
            System.out.println("LinkedList.Node inserted :"+val);
        }
    }
    public void deleteAtMid(int pos)
    {
        int count = getCount();
        //System.out.println("Count of Nodes:"+count);
        if(pos<=0||pos>count)
        {
            System.out.println("Enter a valid Position");
            return;
        }
        if(pos==1)
        {
            deleteatbegin();
            return;
        }
        else if(pos==count)
        {
            deleteatend();
            return;
        }
        else {
            Node t = head;
            for (int i = 1; i < pos-1&&t.next!=null; i++) {
                t = t.next;
            }
            Node v = t.next;
            t.next=t.next.next;
            v.next.prev=t;
            System.out.println("LinkedList.Node Deleted :"+v.data);
            v=null;
        }
    }
    public int getCount()
    {
        if(head==null)
            return 0;
        int c=0;
        Node t = head;
        do{
            c++;
            t=t.next;
        }while(t!=null);
        return c;
    }
    public static void main(String args[])
    {
        DoublyLinkedList cl = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("1.Insert At Begin\t2.Insert At End\t3.Display\t4.Delete at begin\t5.Delete at end\t6.Delete Using key\t7.Insert At Random Position\t8.Delete at Random Position\t9.Key search\t10.Exit\nEnter any value :");
            int n = sc.nextInt();
            switch(n)
            {
                case 1:
                    cl.insertatbegin();
                    break;
                case 2:
                    cl.insertatend();
                    break;
                case 3:
                    cl.display();
                    break;
                case 4:
                    cl.deleteatbegin();
                    break;
                case 5:
                    cl.deleteatend();
                    break;
                case 6:
                    System.out.println("Enter key to search:");
                    int v = sc.nextInt();
                    cl.KeySearch(v);
                    break;
                case 7:
                    System.out.println("Enter position to insert:");
                    int va=sc.nextInt();
                    cl.insertAtMid(va);
                    break;
                case 8:
                    System.out.println("Enter position to delete:");
                    int val=sc.nextInt();
                    cl.deleteAtMid(val);
                    break;
                case 9:
                    System.out.println("Enter Key to search :");
                    int value = sc.nextInt();
                    cl.KeySearch(value);
                    break;
                case 10:
                    flag=false;
                    break;
                default:
                    System.out.println("Enter valid Input......");
                    break;
            }
            System.out.println();
        }while(flag);
    }
}
