package tree;

public class totalNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lh = findHeightLeft(root);
            int rh = findHeightRight(root);
            if (lh == rh) {
                return (1 << lh) - 1;
            }
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
        public int findHeightLeft(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.left;
            }
            return height;
        }
        public int findHeightRight(TreeNode node) {
            int height = 0;
            while (node != null) {
                height++;
                node = node.right;
            }
            return height;
        }
    }

    static public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            Solution sol = new Solution();
            int totalNodes = sol.countNodes(root);
            System.out.println("Total number of nodes in the Complete Binary Tree: " + totalNodes);
        }
    }
}
