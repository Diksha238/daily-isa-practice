package tree;

import java.util.*;

public class ZigZag {
     static class TreeNode{
         int data;
         TreeNode left;
         TreeNode right;
         TreeNode(int val){
             this.data=val;
             this.left=null;
             this.right=null;
         }
     }
     static class Solution{
         public List<List<Integer>> zigZagTraversal(TreeNode root){
             List<List<Integer>> result = new ArrayList<>();
             if(root==null) return result;
             Queue<TreeNode> q= new LinkedList<>();
             q.offer(root);
             boolean LeftToRight=true;
             while(!q.isEmpty()){
                 int size=q.size();
                 Integer[] level = new Integer[size];
                 for(int i=0;i<size;i++){
                     TreeNode node=q.poll();
                     int index=LeftToRight ? i: size-1-i;
                     level[index]=node.data;
                     if(node.left!=null) q.offer(node.left);
                     if(node.right!=null) q.offer(node.right);

                 }
                 LeftToRight=!LeftToRight;
                 result.add(Arrays.asList(level));

             }
             return result;
         }
     }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        Solution sol= new Solution();
        List<List<Integer>> ans=sol.zigZagTraversal(root);
        System.out.println(ans);
    }
}
