package tree;

public class BalancedBinaryTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.data=val;
            left=null;
            right=null;

        }

    }
    static class Solution{
        public boolean isBoolean(TreeNode root){
            return dfsHeight(root)!= -1;
        }
        int dfsHeight(TreeNode root){
            if(root==null) return 0;
            int lh=dfsHeight(root.left);
            if(lh==-1) return -1;
            int rh =dfsHeight(root.right);
            if(rh == -1) return -1;
            if(Math.abs(lh-rh)>1) return -1;
            return Math.max(lh,rh)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        Solution sol=new Solution();
        if (sol.isBoolean(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
