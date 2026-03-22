package tree;

public class InorderPredecesor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    static class Solution{
        public TreeNode inorderPredecessor(TreeNode root,TreeNode p){
            TreeNode predecessor= null;
            while(root != null){
                if(p.val <=root.val){
                    root=root.left;
                }else{
                    predecessor=root;
                    root=root.right;
                }
            }
            return predecessor;
        }
    }
    static class Main{
        public static void main(String[] args) {
            TreeNode root= new TreeNode(5);
            root.left=new TreeNode(3);
            root.left.left=new TreeNode(2);
            root.left.left.left=new TreeNode(1);
            root.left.right=new TreeNode(4);
            root.right=new TreeNode(7);
            root.right.left=new TreeNode(6);
            root.right.right=new TreeNode(9);
            root.right.right.left=new TreeNode(8);
            root.right.right.right=new TreeNode(10);
            Solution sol= new Solution();
            TreeNode p= root.right.right.left;
            TreeNode result = sol.inorderPredecessor(root,p);
            if(result != null) {
                System.out.println("Predecessor: " + result.val);
            }
            else {
                System.out.println("No predecessor");
            }
        }
    }
}
