package tree;

public class twoSum {
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
    static class BSTIterator {
        private java.util.Stack<TreeNode> stack;
        private boolean reverse;
        public BSTIterator(TreeNode root, boolean isReverse) {
            stack = new java.util.Stack<>();
            reverse = isReverse;
            pushAll(root);
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int next() {
            // Get the node on top of the stack
            TreeNode tmpNode = stack.pop();

            // If we are not in reverse mode, move to the right child
            if (!reverse) {
                pushAll(tmpNode.right);
            }
            // If we are in reverse mode, move to the left child
            else {
                pushAll(tmpNode.left);
            }

            // Return the value of the node we just processed
            return tmpNode.val;
        }

        private void pushAll(TreeNode node) {
            // Keep going until node becomes null
            while (node != null) {
                // Push this node into stack
                stack.push(node);
                // If reverse is true, move to right child
                if (reverse) {
                    node = node.right;
                }
                // Otherwise, move to left child
                else {
                    node = node.left;
                }
            }
        }
    }

    static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            // If root is null, tree is empty, return false
            if (root == null) return false;

            // Create two iterators: one from smallest, one from largest
            BSTIterator l = new BSTIterator(root, false);
            BSTIterator r = new BSTIterator(root, true);

            // Get the first values
            int i = l.next();
            int j = r.next();

            // Loop until two values meet
            while (i < j) {
                // If sum is exactly k, return true
                if (i + j == k) return true;
                    // If sum is smaller, move left iterator forward
                else if (i + j < k) i = l.next();
                    // If sum is bigger, move right iterator backward
                else j = r.next();
            }

            // If no such pair found, return false
            return false;
        }
    }
    static public class Main {
        public static void printInOrder(TreeNode root) {
            // If node is null, stop recursion
            if (root == null) return;
            // Visit left subtree
            printInOrder(root.left);
            // Print current node value
            System.out.print(root.val + " ");
            // Visit right subtree
            printInOrder(root.right);
        }

        // Main function to run the program
        public static void main(String[] args) {
            // Create a sample BST
            TreeNode root = new TreeNode(7);
            root.left = new TreeNode(3);
            root.right = new TreeNode(15);
            root.right.left = new TreeNode(9);
            root.right.right = new TreeNode(20);

            // Print inorder traversal to confirm tree
            System.out.print("Tree Initialized: ");
            printInOrder(root);
            System.out.println();

            // Create solution object
            Solution solution = new Solution();

            // Define target sum
            int target = 22;

            // Check if such a pair exists
            boolean exists = solution.findTarget(root, target);

            // Print result
            if (exists) {
                System.out.println("Pair with sum " + target + " exists.");
            } else {
                System.out.println("Pair with sum " + target + " does not exist.");
            }
        }
    }
}
