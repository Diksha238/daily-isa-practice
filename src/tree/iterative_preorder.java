package tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

    /**
     * Problem: Binary Tree Preorder Traversal (Iterative)
     *
     * Preorder Traversal Order:
     *      Root -> Left -> Right
     *
     * Approach:
     * We use a Stack to simulate recursion.
     * 1. Push root to stack.
     * 2. Pop node, add to result.
     * 3. Push right child first.
     * 4. Push left child.

     * Time Complexity: O(n)
     * Space Complexity: O(n)

     * Author: Diksha

     */

    public class iterative_preorder {

        // Definition for a binary tree node
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        public static List<Integer> preorderTraversal(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            if (root == null)
                return result;

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {

                TreeNode current = stack.pop();
                result.add(current.val);


                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }
            }

            return result;
        }

        // Main method for testing
        public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \
              4   5


        */

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            List<Integer> result = preorderTraversal(root);

            System.out.println("Preorder Traversal: " + result);
        }
    }

