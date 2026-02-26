package tree;

public class sameTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.data=val;
            this.left=null;
            this.right=null;
        }
    }
    static class Solution{
        public boolean isSameTree(TreeNode p, TreeNode q){
            if(p==null || q==null)
                return (p==q);
            return (p.data==q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

        }
    }
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        // Creating the second binary tree (Node2)
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Check if the two binary trees are identical and output the result
        if (solution.isSameTree(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }
    }
}
