package tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class iterative_postorder1 {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    static class Solution {
        public List<Integer> postOrder(TreeNode root) {
            Stack<TreeNode> st1 = new Stack<TreeNode>();
            Stack<TreeNode> st2 = new Stack<TreeNode>();
            List<Integer> postOrder = new ArrayList<Integer>();
            if (root == null) return postOrder;
            st1.push(root);
            while (!st1.isEmpty()) {
                root = st1.pop();
                st2.add(root);
                if (root.left != null) st1.push(root.left);
                if (root.right != null) st1.push(root.right);
            }
            while (!st2.isEmpty()) {
                postOrder.add(st2.pop().data);
            }
            return postOrder;
        }
    }



        public static void main(String[] args) {
            // Creating a sample binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);

            // Getting the postorder traversal
            Solution sol = new Solution();
            List<Integer> result = sol.postOrder(root);

            // Printing the postorder traversal result
            System.out.print("Postorder traversal: ");
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

}
