package tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBT {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);

            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;

            root.left = build(preorder, preStart + 1, preStart + numsLeft,
                    inorder, inStart, inRoot - 1, inMap);
            root.right = build(preorder, preStart + numsLeft + 1, preEnd,
                    inorder, inRoot + 1, inEnd, inMap);

            return root;
        }
    }

    static public class Main {
        public static void printInorder(TreeNode root) {
            if (root == null) return;
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }

        public static void main(String[] args) {
            int[] inorder = {9, 3, 15, 20, 7};
            int[] preorder = {3, 9, 20, 15, 7};

            Solution sol = new Solution();
            TreeNode root = sol.buildTree(preorder, inorder);

            System.out.println("Inorder of Unique Binary Tree Created:");
            printInorder(root);
        }
    }
}
