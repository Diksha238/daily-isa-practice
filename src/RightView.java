import java.util.ArrayList;
import java.util.List;

public class RightView {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            left = right = null;
        }
    }

    static class Solution {

        public void rightDFS(TreeNode node, int level, List<Integer> res) {
            if (node == null) return;

            if (res.size() == level)
                res.add(node.val);
            rightDFS(node.right, level + 1, res);
            rightDFS(node.left, level + 1, res);
        }
        public List<Integer> rightView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            rightDFS(root, 0, res);
            return res;
        }
    }

    // Main class for running the program
    class Main {
        public static void main(String[] args) {
            // Create binary tree
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(4);
            root.left.right.right = new TreeNode(5);
            root.left.right.right.right = new TreeNode(6);

            // Create solution instance
            Solution sol = new Solution();
            List<Integer> right = sol.rightView(root);

            // Print right view
            System.out.print("\nRight View: ");
            for (int val : right)
                System.out.print(val + " ");
        }
    }
}
