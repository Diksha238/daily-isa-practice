package tree;

import java.util.ArrayList;
import java.util.List;

public class LargestSmallest {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { data = val; left = null; right = null; }
    }

    static class Solution {
        private int k;
        private int result;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            this.result = -1;
            inorder(root);
            return result;
        }
        private void inorder(TreeNode node) {
            if (node != null) {
                inorder(node.left);
                if (--k == 0) {
                    result = node.data;
                    return;
                }
                inorder(node.right);
            }
        }
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            this.result = -1;
            reverseInorder(root);
            return result;
        }
        private void reverseInorder(TreeNode node) {
            if (node != null) {
                reverseInorder(node.right);
                if (--k == 0) {
                    result = node.data;
                    return;
                }
                reverseInorder(node.left);
            }
        }
        public List<Integer> kLargesSmall(TreeNode root, int k) {
            List<Integer> result = new ArrayList<>();
            result.add(kthSmallest(root, k));
            result.add(kthLargest(root, k));
            return result;
        }
    }
    static public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.left.right = new TreeNode(2);
            root.right = new TreeNode(4);
            Solution solution = new Solution();
            int k = 1;
            List<Integer> result = solution.kLargesSmall(root, k);
            System.out.println(result); // Output: [1, 4]
        }
    }
}
