package Trees;

import java.util.*;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class DFSPractice {
    public static void main(String[] args) {
        int nums[] = {-10,-3,0,5,9};
        int preorder[] = {};
        int inorder[] = {};
        //TreeNode res = buildTree(nums);
        //TreeNode  res = build(preorder,inorder);
        TreeNode root = new TreeNode(10);
        TreeNode a = new TreeNode(20);
        TreeNode b = new TreeNode(30);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left=a;
        root.right=b;
        a.right = new TreeNode(30);
        b.left=c;
        b.right=d;
        //levelOrder(root);
        //System.out.println(serialize(root));
        //levelOrder(deserialize(serialize(root)));
        //System.out.println(hasPathSum(root,40));
        System.out.println(hasMaxSum(root));
    }

    private static TreeNode build(int[]preorder,int[]inorder)
    {
        if(inorder.length==0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        if(inorder.length==1) return root;
        int ind=0;
        for(int i=0;i<inorder.length;i++)
        {
            if(preorder[0]==inorder[i]){
                ind = i;
                break;
            }
        }
        root.left = build(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,0,ind));
        root.right = build(Arrays.copyOfRange(preorder,1,preorder.length),Arrays.copyOfRange(inorder,ind+1,inorder.length));
        return root;
    }

    public static String serialize(TreeNode root)
    {
        StringBuilder res = new StringBuilder();
        helper1(root,res);
        return res.toString();
    }

    public static void helper1(TreeNode node,StringBuilder res)
    {
        if(node==null){
            res.append("null,");
            return;
        }
        res.append(node.val+",");
        helper1(node.left,res);
        helper1(node.right,res);
    }
    static int counter = 0;
    public static TreeNode deserialize(String data)
    {
        String arr[] = data.split(",");
        arr = Arrays.copyOfRange(arr,0,arr.length);
        //System.out.println(Arrays.toString(arr));
        return helper2(arr);
    }
    public static TreeNode helper2(String arr[])
    {
        if(arr[counter].equals("null")) return null;
        if(counter>=arr.length-2) return null;
        TreeNode node = new TreeNode(Integer.parseInt(arr[counter]));
        counter++;
        node.left = helper2(arr);
        counter++;
        node.right = helper2(arr);
        return node;
    }

    static int max = Integer.MIN_VALUE;
    public static int hasMaxSum(TreeNode root) {
        if(root==null) return -1;
        helper(root,0);
        return max;
    }

    public static void helper(TreeNode node,int curr)
    {
        if(node.left==null && node.right==null)
        {
            max = Math.max(max,curr+node.val);
            return;
        }
        if(node.left!=null)
                helper(node.left,curr+node.val);

        if(node.right!=null)
                helper(node.right,curr+node.val);
    }

    public static TreeNode buildTree(int arr[])
    {
        if(arr.length==0)
            return null;
        if(arr.length==1)
        {
               return new TreeNode(arr[0]);
        }
        int mid;
        if(arr.length%2==0)
            mid = (arr.length/2)-1;
        else
            mid = arr.length/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = buildTree(Arrays.copyOfRange(arr,0,mid));
        node.right = buildTree(Arrays.copyOfRange(arr,mid+1,arr.length));
        return node;
    }

    private static void levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> l = new ArrayList<>();
            //System.out.println(curr.value);
            int n = q.size();
            for(int i=0;i<n;i++)
            {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            //System.out.println(l);
            res.add(l);
        }
        System.out.println(res);
    }
    public void convert(TreeNode node)
    {
        if(node==null) return;
        TreeNode rightMost = findRight(node.left);
        if(rightMost!=null){
            rightMost.right = node.right;
            rightMost.left = null;
        }
        node.right = node.left;
        node.left=null;
        convert(node.right);
    }
    public TreeNode findRight(TreeNode node)
    {
        if(node==null) return null;
        while(node.right!=null) node = node.right;
        return node;
    }
}
