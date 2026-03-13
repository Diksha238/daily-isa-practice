package tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> preorder = new ArrayList<>();
            TreeNode curr =root;
            while(curr !=null){
                if(curr.left== null){
                    preorder.add(curr.val);
                    curr=curr.right;
                }else{
                    TreeNode prev = curr.left;
                    while(prev.right !=null && prev.right!=curr){
                        prev=prev.right;
                    }
                    if(prev.right == null){
                        prev.right=curr;
                        preorder.add(curr.val);
                        curr=curr.left;
                    }
                    else{
                        prev.right=null;
                        curr=curr.right;
                    }
                }
            }
            return preorder;
        }
    }
    static public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.right.right = new TreeNode(6);

            Solution sol = new Solution();

            List<Integer> preorder = sol.preorderTraversal(root);

            System.out.print("Binary Tree Morris Preorder Traversal: ");
            for (int i = 0; i < preorder.size(); i++) {
                System.out.print(preorder.get(i) + " ");
            }
            System.out.println();
        }
    }
}
