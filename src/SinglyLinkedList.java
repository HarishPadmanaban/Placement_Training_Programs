import java.util.Scanner;

public class SinglyLinkedList {
    class Node{
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public Node head = null;
    public Node tail = null;
    public void addNode(int data)
    {
        Node newNode = new Node(data);
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }        }

    public void begininsert(int data)
    {
        Node newNode = new Node(data);
        //Checks if the list is empty
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            newNode.next=head;
            head = newNode;
        }
    }


     void searchInEvenPosition(int key)
    {        int counter = 0;
        Node temp = head;
        while(temp != null)
        {
            if(counter %2 == 0){
                if(temp.data == key){
                    System.out.println("Found at position : " + counter);
                    return;
                }
            }            counter ++;             temp = temp.next;
        }

        System.out.println("Not Found!");
    }
    public void display() {
        //Node current will point to head
        Node temp = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
     Node delatend()
    {
        if (head == null)
            return null;
        if (head.next == null) {
            return null;
        }

        // Find the second last node
        Node current = head;
        while (current.next.next != null)
        {
            current = current.next;
        }
        tail=current;
        current.next = null;

        return head;
    }
    void isPalindrome()
    {
        Node temp = head;
        while(temp!=null)
        {
            int val = temp.data;
            int te = val;
            int rev=0;
            while(te>0)
            {
                rev=(rev*10)+(te%10);
                te/=10;
            }
            if(val==rev)
            {
                System.out.println(temp.data+" is palindrome");
            }
            else{
                System.out.println(temp.data+" is not a palindrome");
            }
            temp=temp.next;
        }
    }
    public void reverseUsingRecursion()
    {
         Node t =recurssionReverse(head);
         t.next=null;
         display();
    }

    public Node recurssionReverse(Node curr) {
        if(curr.next==null)
        {
            head = curr;
            return curr;
        }
        Node n = recurssionReverse(curr.next);
        n.next = curr;
        return curr;
    }

    public void reverseList()
    {
        if(head==null || head.next==null)
            display();
        Node temp = head.next;
        Node prev = head;
        prev.next=null;
        Node curr=temp;
        while(temp!=null)
        {
            curr = temp;
            temp=temp.next;
            curr.next = prev;
            prev = curr;
            //System.out.println(curr.data);
        }
        head = curr;
        display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e;
        SinglyLinkedList l = new SinglyLinkedList();
        do
        {
            System.out.println("1.Add node\n2.Delete node\n3.Display\n4.searchInEvenPosition\n5.begininsert\n6.PalindromeCheck\n7.String.Reverse\n8.String.Reverse Using Recurrsion");
            int c = sc.nextInt();

            switch(c)
            {
                case 1:
                    int n = sc.nextInt();
                    l.addNode(n);
                    break;
                case 2:
                    l.delatend();
                    break;
                case 3:
                    l.display();
                    break;
                case 4:
                    l.searchInEvenPosition(10);
                    break;
                case 5:
                    l.begininsert(5);
                    break;
                case 6:
                    l.isPalindrome();
                    break;
                case 7:
                    l.reverseList();
                    break;
                case 8:
                    l.reverseUsingRecursion();
                    break;
                default:
                    System.out.println("Input Invalid");
                    break;
            }
            System.out.println("Do you want to continue (1/0):");
            e = sc.nextInt();
        }while(e==1);
    }
}
