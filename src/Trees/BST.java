package Trees;
import java.util.ArrayList;
import java.util.Scanner;


public class BST {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        TreeNode root = new TreeNode(5);
        TreeNode obj1 = new TreeNode(3);
        TreeNode obj2 = new TreeNode(6);
        TreeNode obj3 = new TreeNode(2);
        TreeNode obj4 = new TreeNode(4);
        TreeNode obj5 = new TreeNode(7);
        root.left = obj1;
        root.right = obj2;
        obj1.left = obj3;
        obj1.right = obj4;
        obj2.right = obj5;
        boolean flag = true;
        System.out.println(findTarget(root,9));
//        do
//        {
//            System.out.println("1.Insert\n2.Display\n3.Exit");
//            int ch = sc.nextInt();
//            switch(ch) {
//                case 1:
//                    if (root == null) {
//                        System.out.println("Enter root value :");
//                        int val = sc.nextInt();
//                        root = new Node(val);
//                    } else {
//                        System.out.print("Enter value to insert:");
//                        int val = sc.nextInt();
//                        insert(val, root);
//                    }
//                    break;
//                case 2:
//                    display(root);
//                    System.out.println();
//                    break;
//                case 3:
//                    flag = false;
//                    break;
//            }
//        }while(flag);
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
    public static boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        return helper(root,k,al);
    }

    public static boolean helper(TreeNode root,int k, ArrayList<Integer> list)
    {
        if(root==null) return false;
        if(list.contains(k-root.val)) return true;
        list.add(k-root.val);
        boolean left = helper(root.left,k,list);
        if(left) return true;
        boolean right = helper(root.right,k,list);
        if(right) return true;
        return false;
    }
}

