package tree;

public class LCAInBst {
    static class TreeNode{
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
        public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
            if(root==null) return null;
            int curr=root.val;
            if(curr<p.val&& curr<q.val){
                return lowestCommonAncestor(root.right,p,q);
            }
            if(curr>p.val && curr>q.val){
                return lowestCommonAncestor(root.left,p,q);
            }
            return root;
        }
    }
    static class Main{
        public static void main(String[] args) {
            TreeNode root=new TreeNode(10);

            root.left=new TreeNode(4);
            root.left.left=new TreeNode(3);
            root.left.left.left=new TreeNode(1);
            root.left.left.left.right=new TreeNode(2);
            root.left.right=new TreeNode(8);
            root.left.right.left=new TreeNode(6);
            root.left.right.right=new TreeNode(9);
            root.left.right.left.left=new TreeNode(5);
            root.right=new TreeNode(13);
            root.right.right=new TreeNode(15);
            root.right.left=new TreeNode(11);
            Solution sol=new Solution();
            TreeNode p = root.left.right.left; // node with value 5
            TreeNode q = root.left.right.right;
            TreeNode result=sol.lowestCommonAncestor(root,p,q);
            System.out.println("LCA : "+ result.val);
        }
    }
}
