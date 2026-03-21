package tree;

public class bstGeneration {
    static class TreeNode{
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
        public TreeNode bstFromPreorder(int [] preorder){
            return bstFromPreorder(preorder,Integer.MAX_VALUE,new int[]{0});
        }
        public TreeNode bstFromPreorder(int []preorder,int bound,int[]i){
            if(i[0]==preorder.length || preorder[i[0]]>bound) return null;
            TreeNode root= new TreeNode(preorder[i[0]++]);
            root.left=bstFromPreorder(preorder,root.data,i);
            root.right=bstFromPreorder(preorder,bound,i);
            return root;
        }
    }
    static class Main {
        public static void main(String[] args) {

            Solution sol = new Solution();

            int[] preorder = {8, 5, 1, 7, 10, 12};

            TreeNode root = sol.bstFromPreorder(preorder);


            System.out.print("Inorder Traversal: ");
            inorder(root);
        }


        public static void inorder(TreeNode root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
