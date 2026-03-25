package tree;

public class largestBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
    static class Solution {

        static class Info {
            boolean isBST;
            int min, max, sum;

            Info(boolean isBST, int min, int max, int sum) {
                this.isBST = isBST;
                this.min = min;
                this.max = max;
                this.sum = sum;
            }
        }

        int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            solve(root);
            return maxSum;
        }

        private Info solve(TreeNode root) {
            if (root == null) {
                return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            Info left = solve(root.left);
            Info right = solve(root.right);

            // Check BST condition
            if (left.isBST && right.isBST &&
                    root.val > left.max && root.val < right.min) {

                int sum = root.val + left.sum + right.sum;

                maxSum = Math.max(maxSum, sum);

                int min = Math.min(root.val, left.min);
                int max = Math.max(root.val, right.max);

                return new Info(true, min, max, sum);
            }

            return new Info(false, 0, 0, 0);
        }
    }
    static class Main {

        static class Info {
            boolean isBST;
            int min, max, sum;

            Info(boolean isBST, int min, int max, int sum) {
                this.isBST = isBST;
                this.min = min;
                this.max = max;
                this.sum = sum;
            }
        }

        static int maxSum = 0;

        public static int maxSumBST(TreeNode root) {
            solve(root);
            return maxSum;
        }

        private static Info solve(TreeNode root) {
            if (root == null) {
                return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }

            Info left = solve(root.left);
            Info right = solve(root.right);


            if (left.isBST && right.isBST &&
                    root.val > left.max && root.val < right.min) {

                int sum = root.val + left.sum + right.sum;

                maxSum = Math.max(maxSum, sum);

                int min = Math.min(root.val, left.min);
                int max = Math.max(root.val, right.max);

                return new Info(true, min, max, sum);
            }

            return new Info(false, 0, 0, 0);
        }

        public static void main(String[] args) {


            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(4);
            root.right = new TreeNode(3);

            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);

            root.right.right = new TreeNode(5);

            int result = maxSumBST(root);

            System.out.println("Maximum Sum BST = " + result);
        }
    }
}
