package tree;

public class LCA {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null || root == p || root == q) {
                return root;
            }

            // Search in left and right subtrees
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // Result
            if (left == null) return right;
            if (right == null) return left;
            return root; // Both sides returned non-null, this is the LCA
        }
    }

    // Separate Main class with public keyword (file should be named Main.java)
    static public class Main {
        public static void main(String[] args) {
            // Construct a sample binary tree
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

            Solution solution = new Solution();
            TreeNode p = root.left;       // Node with value 5
            TreeNode q = root.right;      // Node with value 1

            TreeNode lca = solution.lowestCommonAncestor(root, p, q);
            System.out.println("Lowest Common Ancestor: " + lca.data);
        }
    }
}

