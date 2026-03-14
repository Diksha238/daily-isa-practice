package tree;

public class flattenBt {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class Solution {
        public void flatten(TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode pre = curr.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    pre.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
                curr = curr.right;
            }
        }
    }
    static class Main {
        public static void printPreorder(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
        public static void printFlattenTree(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val + " ");
            printFlattenTree(root.right);
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.right = new TreeNode(6);
            root.right.right = new TreeNode(7);
            root.right.left = new TreeNode(8);

            Solution sol = new Solution();

            System.out.print("Binary Tree Preorder: ");
            printPreorder(root);
            System.out.println();

            sol.flatten(root);

            System.out.print("Binary Tree After Flatten: ");
            printFlattenTree(root);
            System.out.println();
        }
    }
}
