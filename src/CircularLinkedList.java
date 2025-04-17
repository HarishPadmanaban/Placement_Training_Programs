import java.util.*;
public class CircularLinkedList {
    class Node
    {
        int data;
        Node next;

    }
    public Node head;
    public void display()
    {
        if(head==null)
        {
            System.out.println("Nothing to print");
            return;
        }
        else{
            Node temp = head;
            if(temp.next==head){
                System.out.println(temp.data);
                return;
            }
            else{
                while(temp.next!=head)
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
        Node n = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to insert:");
        int val = sc.nextInt();
        n.data=val;
        n.next=head;
        if(head!=null)
        {
            Node t = head;
            while(t.next!=head)
            {
                t=t.next;
            }
            t.next=n;
        }
        else
        {
            n.next=n;
        }
        head = n;
        System.out.println("Node Inserted Successfully : "+val);
    }
    public void insertatend()
    {
        if(head==null){
            insertatbegin();
            return;
        }
        Node n = new Node();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value to insert:");
        int val = sc.nextInt();
        n.data=val;
        n.next=head;
        if(head!=null)
        {
            Node t = head;
            while(t.next!=head)
            {
                t=t.next;
            }
            t.next=n;
        }
        else
        {
            n.next=n;
        }
        System.out.println("Node Inserted Successfully : "+val);
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
            if(temp.next==head)
            {
                System.out.println("Node deleted:"+temp.data);
                head=null;
                return;
            }
            while(temp.next!=head)
            {
                temp=temp.next;
            }
            System.out.println("Node Deleted:"+head.data);
            head=head.next;
            temp.next=head;
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
                System.out.println("Node deleted:"+temp.data);
                head=null;
                return;
            }
            while(temp.next.next!=head)
            {
                temp=temp.next;
            }
            System.out.println("Node Deleted:"+temp.next.data);
            temp.next=head;
        }
    }
    public void deleteUsingKey()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Key value to Search:");
        int key = sc.nextInt();
        int flag=1;
        Node curr=head;
        Node prev=null;
        if(head==null)
        {
            System.out.println("Nothing to delete");
            return;
        }
        else{
            while(curr.data!=key)
            {
                if(curr.next==head)
                {
                    System.out.println("Key not found in the List");
                    flag=0;
                    break;
                }
                prev=curr;
                curr=curr.next;
            }
        }
        if(flag==0)
        {
            return;
        }
        if(curr==head&&curr.next==head)
        {
            deleteatbegin();
        }
        else if(curr.next==head)
        {
            deleteatend();
        }
        else{
            prev.next=curr.next;
            curr=null;
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
        if(pos==1)
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
            Node b = new Node();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter value to insert:");
            int val = sc.nextInt();
            b.data=val;
            Node t = head;
            for (int i = 1; i < pos-1&&t.next!=head; i++) {
                t = t.next;
            }
            b.next=t.next;
            t.next=b;
            System.out.println("Node inserted :"+val);
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
            for (int i = 1; i < pos-1&&t.next!=head; i++) {
                t = t.next;
            }
            Node v = t.next;
            t.next=t.next.next;
            System.out.println("Node Deleted :"+v.data);
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
        }while(t!=head);
        return c;
    }
    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.print("1.Insert At Begin\t2.Insert At End\t3.Display\t4.Delete at begin\t5.Delete at end\t6.Delete Using key\t7.Insert at Position\t8.Delete at Position\t9.Total Number of Nodes\t10.Exit\nEnter any value :");
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
                    cl.deleteUsingKey();
                    break;
                case 7:
                    System.out.print("Enter position to insert:");
                    int p = sc.nextInt();
                    cl.insertAtMid(p);
                    break;
                case 8:
                    System.out.print("Enter position to delete:");
                    int po = sc.nextInt();
                    cl.deleteAtMid(po);
                    break;
                case 9:
                    System.out.println("Number of nodes in the list :"+cl.getCount());
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
