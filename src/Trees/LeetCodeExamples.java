package Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCodeExamples {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node obj1 = new Node(2);
        Node obj2 = new Node(3);
        Node obj3 = new Node(4);
        Node obj4 = new Node(5);
        Node obj5 = new Node(15);
        Node obj6 = new Node(7);
        Node obj7 = new Node(13);
        Node obj8 = new Node(14);
        root.left = obj1;
        root.right = obj2;
        //obj1.left = obj3;
        obj1.right = obj3;
        obj2.right = obj4;
        //obj2.right = obj6;
        //obj5.left=obj7;
        //obj5.right = obj8;
        //System.out.println(root.value);
        //preOrderDisplay(root);
        //System.out.println();
        levelOrder(root);
        //zigzag(root);
        //System.out.println(level(root,4,0));
       //System.out.println(parentOf(root,4));
        //System.out.println(level(root,5,0));
        //System.out.println(parentOf(root,5));
        //System.out.println(isCousins(root,5,4));
    }

    private static boolean isCousins(Node root, int x, int y) {
        return (level(root,x,0)==level(root,y,0)) &&(parentOf(root,x)!=parentOf(root,y));
    }

    private static int parentOf(Node root, int val) {
        if(root==null) return -1;
        if(root.left!=null) {
            if(root.left.value==val)
                return root.value;
        }
        int leftCheck = parentOf(root.left,val);
        if(leftCheck!=-1) return leftCheck;
        if(root.right!=null){
            if(root.right.value==val)
                return root.value;
        }
        return parentOf(root.right,val);
    }

    private static int level(Node root, int val,int l) {
        if(root==null) return -1;
        if(root.value==val) return l;
        int leftCheck= level(root.left,val,l+1);
        if(leftCheck!=-1) return leftCheck;
        return level(root.right,val,l+1);
    }


    private static void zigzag(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean isReverse = false;
        while(!q.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            //System.out.println(curr.value);
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                Node curr = q.poll();
                if(isReverse) l.add(0,curr.value);
                else l.add(curr.value);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            //System.out.println(l);
            res.add(l);
            isReverse = !isReverse;
        }
        System.out.println(res);
    }

    private static void levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
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
            //System.out.println(l);
            res.add(l);
        }
        System.out.println(res);
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
}
