package tree;

import java.util.Stack;

public class BSTiterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    static class Iterator{
        private Stack<TreeNode> stack=new Stack<TreeNode>();
        public Iterator (TreeNode root){
            pushAll(root);
        }
        public boolean hasNext(){
            return !stack.isEmpty();
        }
        public int next(){
            TreeNode tmpNode=stack.pop();
            pushAll(tmpNode.right);
            return tmpNode.val;
        }
        public void pushAll(TreeNode node){
            for(;node!=null;stack.push(node),node=node.left);
        }
    }
    static class Main{
        public static void main(String[] args) {
            TreeNode root=new TreeNode(7);
            root.left=new TreeNode(3);
            root.left.left=new TreeNode(2);
            root.left.left.left=new TreeNode(1);
            root.left.right=new TreeNode(6);
            root.left.right.left=new TreeNode(5);
            root.left.right.left.left=new TreeNode(4);
            root.right=new TreeNode(10);
            root.right.left=new TreeNode(9);
            root.right.left.left=new TreeNode(8);
            Iterator it=new Iterator(root);
            while(it.hasNext()){
                System.out.print(it.next() + " ");
            }
        }
    }
}
