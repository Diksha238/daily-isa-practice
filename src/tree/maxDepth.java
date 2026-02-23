package tree;

public class maxDepth {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int val){
            int data=val;
            left=null;
            right=null;
        }
    }
    static class Solution{
        public int maxDepth(Node root){
            if(root==null) return 0;
            int lh=maxDepth(root.left);
            int rh=maxDepth(root.right);
            return 1+Math.max(lh,rh);
        }
    }

    public static void main(String[] args) {
        Node root= new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.right=new Node(6);
        root.right.right.right=new Node(7);

        Solution sol=new Solution();
        int depth=sol.maxDepth(root);
        System.out.println("Maximum Depth of binary tree "+ depth);
    }
}
