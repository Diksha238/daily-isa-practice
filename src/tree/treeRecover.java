package tree;

public class treeRecover {


        //  Tree Node
        static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        //  Solution Class
        static class Solution {
            TreeNode first = null, second = null, prev = null;

            public void recoverTree(TreeNode root) {
                inorder(root);

                //  Swap values
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }

            private void inorder(TreeNode root) {
                if (root == null) return;

                inorder(root.left);

                //  Violation check
                if (prev != null && prev.val > root.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = root;
                }

                prev = root;

                inorder(root.right);
            }
        }


        public static void printInorder(TreeNode root) {
            if (root == null) return;
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }


        public static void main(String[] args) {



            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            root.right.left = new TreeNode(2);

            System.out.print("Before Recovery (Inorder): ");
            printInorder(root);

            Solution sol = new Solution();
            sol.recoverTree(root);

            System.out.print("\nAfter Recovery (Inorder): ");
            printInorder(root);
        }
    }

