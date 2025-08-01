package Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BinaryTree {
    static Node root;
    public static void main(String[] args) {
        //Node obj = new Node();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        do
        {
            System.out.println("1.Insertion\n2.Display\n3.No of Levels\n4.Exit");
            int ch = sc.nextInt();
            switch(ch)
            {
                case  1:
                    System.out.println("Enter root node :");
                    int r = sc.nextInt();
                    root = new Node(r);
                    //System.out.println(obj+" "+obj.value+" "+obj.left+" "+obj.right);
                    populate(sc,root);
                    break;
                case 2:
                    display(sc,root);
                    System.out.println();
                    break;
                case 3:
                    System.out.println(levels(root,0));
                    break;
                case 4:
                    flag = false;
                    break;
            }
        }while(flag);
    }

    public static void populate(Scanner sc ,Node n)
    {
        System.out.println("Do you want insert left of "+n.value+" (0/1) :");
        int flag1 = sc.nextInt();
        if(flag1!=0)
        {
            System.out.println("Enter left of "+n.value+" :");
            int val = sc.nextInt();
            n.left = new Node(val);
            populate(sc,n.left);
        }
        System.out.println("Do you want insert right of "+n.value+" (0/1) :");
        int flag2 = sc.nextInt();
        if(flag2!=0){
            System.out.println("Enter right of "+n.value+" :");
            int val = sc.nextInt();
            n.right = new Node(val);
            populate(sc,n.right);
        }
    }
    public static void display(Scanner sc,Node root)
    {
        System.out.println("1.Pre order\n2.In order\n3.Post order\n4.Level Order");
        int ch = sc.nextInt();
        if(ch==1)
        {
            preOrderDisplay(root);
        }
        else if(ch==2)
        {
            inOrderDisplay(root);
        }
        else if(ch==3)
        {
            postOrderDisplay(root);
        }
        else if(ch==4)
        {
            levelOrder(root);
        }
    }

    private static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            //System.out.println(curr.value);
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                Node curr = q.poll();
                l.add(curr.value);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            System.out.println(l);
        }
    }

    public static void preOrderDisplay(Node root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.value+" ");
        preOrderDisplay(root.left);
        preOrderDisplay(root.right);
    }
    public static void inOrderDisplay(Node root)
    {
        if(root==null)
        {
            return;
        }
        inOrderDisplay(root.left);
        System.out.print(root.value+" ");
        inOrderDisplay(root.right);
    }
    public static void postOrderDisplay(Node root)
    {
        if(root==null)
        {
            return;
        }

        postOrderDisplay(root.left);
        postOrderDisplay(root.right);
        System.out.print(root.value+" ");
    }
    public static int levels(Node node,int l)
    {
        if(node==null) return l;
        int leftLevel = levels(node.left,l+1);
        int rightLevel = levels(node.right,l+1);
        return Math.max(leftLevel,rightLevel);
    }

}

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
