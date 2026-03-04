package tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class Solution {
        // Function to find the maximum width of binary tree
        public int widthOfBinaryTree(TreeNode root) {

            if (root == null)
                return 0;

            int maxWidth = 0;


            Queue<preInPostTraversal.Pair<TreeNode, Integer>> q = new LinkedList<>();


            q.offer(new preInPostTraversal.Pair<>(root, 0));


            while (!q.isEmpty()) {


                int size = q.size();
                int minIndex = q.peek().getValue();
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    preInPostTraversal.Pair<TreeNode, Integer> p = q.poll();
                    TreeNode node = p.getKey();
                    int currIndex = p.getValue() - minIndex;
                    if (i == 0)
                        first = currIndex;
                    if (i == size - 1)
                        last = currIndex;
                    if (node.left != null)
                        q.offer(new preInPostTraversal.Pair<>(node.left,
                                2 * currIndex + 1));
                    if (node.right != null)
                        q.offer(new preInPostTraversal.Pair<>(node.right,
                                2 * currIndex + 2));
                }
                maxWidth = Math.max(maxWidth, last - first + 1);
            }
            return maxWidth;
        }
    }
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.right = new TreeNode(2);
            root.left.left = new TreeNode(5);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(9);
            Solution sol = new Solution();
            System.out.println("Maximum width: " +
                    sol.widthOfBinaryTree(root));
        }
    }
