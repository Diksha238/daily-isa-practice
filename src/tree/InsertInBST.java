package tree;

public class InsertInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }
    static class Solution{
        public TreeNode insert(TreeNode root,int val){
            if(root==null ) return new  TreeNode(val);
            TreeNode cur = root;
            while(true){
                if(cur.val <=val){
                    if(cur.right!= null) cur=cur.right;
                    else{
                        cur.right=new TreeNode(val);
                        break;
                    }
                }else{
                    if(cur.left!= null) cur=cur.left;
                    else{
                        cur.left=new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }
    static public class Main {
        static void inorder(TreeNode root){
            if(root == null) return;
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
        public static void main(String[] args) {

            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            Solution obj = new Solution();
            TreeNode result = obj.insert(root, 5);
            inorder(result);

        }
    }
}
