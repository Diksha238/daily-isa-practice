package tree;

public class validBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            data=val;
            left=null;
            right=null;
        }
    }
    static class Solution{
        public boolean isValidBST(TreeNode root){
            return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        public boolean isValidBST(TreeNode root,long minVal,long maxVal){
            if(root==null) return true;
            if(root.data >=maxVal || root.data<=minVal){
                return false;
            }
            return isValidBST(root.left,minVal,root.data) && isValidBST(root.right,root.data,maxVal);
        }
    }
    static public class Main{
        public static void main(String[] args) {
            TreeNode root= new TreeNode(4);
            root.left = new TreeNode(1);
            root.right=new TreeNode(6);
            root.right.left=new TreeNode(5);
            root.right.right=new TreeNode(8);
            Solution sol= new Solution();
            boolean result= sol.isValidBST(root);
            System.out.println(result);
        }
    }
}
