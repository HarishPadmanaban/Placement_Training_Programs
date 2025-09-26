package LinkedList;

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
        }
    }


    public void begininsert(int data)
    {
        Node newNode = new Node(data);
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
        //LinkedList.Node current will point to head
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

    public int len()
    {
        Node temp = head;
        int i=0;
        while(temp!=null)
        {
            i++;
            temp = temp.next;
        }
        return i;
    }
    public void reverseSpecific(int l,int r)
    {
        if(l==r)
            return;
        Node prev = null;
        Node curr = head;
        for(int i=0;i<l-1&&curr!=null;i++)
        {
            prev = curr;
            curr = curr.next;
        }
        Node last = prev;
        Node newend = curr;
        Node next = curr.next;
        for(int i=0;i<r-l+1 && curr!=null;i++)
        {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null)
                next = next.next;
        }
        if(last != null)
        {
            last.next = prev;
        }
        else{
            head = prev;
        }
        newend.next = curr;
        display();
    }

    public void rotateByKNodes(int k)
    {
        int len = len();
        k = k%len;
        if(k==0)
        {
            display();
            return;
        }
        Node prev = null;
        Node curr = head;
        for(int i=0;i<len-k;i++)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        Node newhead = curr;
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        curr.next = head;
        head = newhead;
        display();
    }

    public void palindromeList()
    {
        if(head==null && head.next==null)
        {
            System.out.println("Palindrome");
            return;
        }
        Node temp = head;
        int len = len();
        int left = len/2;
        //System.out.println(left+" "+len);
        reverseSpecific(left+1,len);
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        while(slow != null)
        {
            System.out.println(slow.data+" "+temp.data);
            System.out.println(slow.data==temp.data);
            //if(slow.data!=temp.data)
                //return false;
            slow = slow.next;
            temp = temp.next;
        }

        /*
          public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next); // reverse second list
        slow.next = null;
        while(rev != null) {
            if(head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }
        return true;
         */
    }

    public void reorderList() {
        int len = len();
        int left = len / 2;
        reverseSpecific(left + 1, len);
        display();
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
        Node hf = head;
        Node hs = slow;
        while (hf != slow || hs != null) {
            Node ftemp = hf;
            hf = hf.next;
            Node stemp = hs;
            if(hs!=null)
                hs = hs.next;
            ftemp.next = stemp;
            if (hf != slow)
                stemp.next = hf;
        }
    }
    public void oddEvenList()
    {
        if(head.next==null||head.next.next==null)
        {
            display();
            return;
        }
        Node oddp = head;
        Node evenp = head.next;
        Node evenHead = evenp;
        Node oddtemp = oddp.next.next;
        Node eventemp = evenp.next.next;
        while(eventemp!=null && oddtemp!=null)
        {
            oddp.next = oddtemp;
            evenp.next = eventemp;
            oddp =  oddtemp;
            evenp = eventemp;
            oddtemp = oddp.next.next;
            if(evenp.next!=null) eventemp = evenp.next.next;
        }

        if(eventemp==null && oddtemp!=null)
        {
            oddp.next=oddtemp;
            oddp = oddtemp;
        }
        if(evenp.next!=null)
            evenp.next = null;
        oddp.next = evenHead;
        display();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e;
        SinglyLinkedList l = new SinglyLinkedList();
        do
        {
            System.out.println("1.Add node\n2.Delete node\n3.Display\n4.searchInEvenPosition\n5.begininsert\n6.PalindromeCheck\n7.Reverse\n8.Reverse Using Recurrsion\n9.Odd Even Separtion of List\n10.ReversePortion\n11.Palindrome or Not\n12. Reorder List\n13.Rotate list by K nodes ");
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
                case 9:
                    l.oddEvenList();
                    break;
                case 10:
                    l.reverseSpecific(2,4);
                    break;
                case 11:
                    l.palindromeList();
                    break;
                case 12:
                    l.reorderList();
                    break;
                case 13:
                    int k = sc.nextInt();
                    l.rotateByKNodes(k);
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
