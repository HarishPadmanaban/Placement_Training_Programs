package Trees;
import Trees.Node;

import java.util.Scanner;

public class BST {
    static Node root;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do
        {
            System.out.println("1.Insert\n2.Display\n3.Exit");
            int ch = sc.nextInt();
            switch(ch) {
                case 1:
                    if (root == null) {
                        System.out.println("Enter root value :");
                        int val = sc.nextInt();
                        root = new Node(val);
                    } else {
                        System.out.print("Enter value to insert:");
                        int val = sc.nextInt();
                        insert(val, root);
                    }
                    break;
                case 2:
                    display(root);
                    System.out.println();
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }while(flag);
    }

    public static void insert(int val,Node n)
    {
        if(n==null)
        {
            return;
        }
        if(val<n.value)
        {
            if(n.left==null)
                n.left =new Node(val);
            else
                insert(val,n.left);
        }
        else{
            if(n.right==null)
                n.right =new Node(val);
            else
                insert(val,n.right);
        }
    }
    public static void display(Node n)
    {
        if(n==null)
        {
            //System.out.println("Empty");
            return;
        }
        display(n.left);
        System.out.print(n.value+" ");
        display(n.right);
    }
}

