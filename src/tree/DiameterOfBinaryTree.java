package tree;

public class DiameterOfBinaryTree {
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
        public int Diameter(TreeNode root){
            int[] dia=new int[1];
            dia[0]=0;
            height(root,dia);
            return dia[0];
        }
        private int height(TreeNode root,int[] dia){
            if(root==null) return 0;
            int[] lh=new int[1];
            lh[0]=height(root.left,dia);
            int[] rh =new int[1];
            rh[0]= height(root.right,dia);
            dia[0]=Math.max(dia[0],lh[0]+rh[0]);
            return 1+Math.max(lh[0],rh[0]);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);
        Solution solution = new Solution();

        // Calculate the diameter of the binary tree
        int diameter = solution.Diameter(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }
}
