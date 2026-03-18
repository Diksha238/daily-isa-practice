package tree;

public class deleteInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }
    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null){
                return null;
            }
            if(root.val==key){
                return helper(root);
            }
            TreeNode dummy = root;
            while(root!= null){
                if(root.val>key){
                    if(root.left!=null && root.left.val==key){
                        root.left=helper(root.left);
                        break;
                    }else{
                        root=root.left;
                    }
                }else{
                    if(root.right!=null && root.right.val==key){
                        root.right=helper(root.right);
                        break;
                    }else{
                        root=root.right;
                    }
                }
            }
            return dummy;
        }
        public TreeNode helper(TreeNode root){
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode rightChild=root.right;
                TreeNode lastRight=findLastRight(root.left);
                lastRight.right=rightChild;
                return root.left;
            }
        }
        public TreeNode findLastRight(TreeNode root){
            if(root.right==null){
                return root;
            }
            return findLastRight(root.right);
        }
    }
    static public class Main {

        public static void inorder(TreeNode root) {
            if (root == null) return;

            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }

        public static void main(String[] args) {

            // Creating BST
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(7);

            System.out.println("Before Deletion:");
            inorder(root);

            Solution obj = new Solution();

            // Delete node
            root = obj.deleteNode(root, 3);

            System.out.println("\nAfter Deletion:");
            inorder(root);
        }
    }
}
