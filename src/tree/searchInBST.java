package tree;

public class searchInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    static class solution {
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = val < root.val ? root.left : root.right;
            }
            return root;
        }
    }

    static public class Main {
        public static void main(String[] args) {

            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(2);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);

            solution obj = new solution();
            TreeNode result = obj.searchBST(root, 2);

            if (result != null)
                System.out.println("Node found: " + result.val);
            else
                System.out.println("Node not found");
        }
    }
}
