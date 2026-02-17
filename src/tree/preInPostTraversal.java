package tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preInPostTraversal {
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
    static class Pair<K, V> {
            private K key;
            private V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }
        }


    static class Solution{
        public List<List<Integer>> preInPost(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> pre = new ArrayList<Integer>();
            List<Integer> in = new ArrayList<Integer>();
            List<Integer> post = new ArrayList<Integer>();

            if (root == null) {
                result.add(pre);
                result.add(in);
                result.add(post);
                return result;
            }
            Stack<Pair<TreeNode, Integer>> st = new Stack<>();
            st.push(new Pair<>(root, 1));


            while (!st.isEmpty()) {
                Pair<TreeNode, Integer> it = st.pop();
                if (it.getValue() == 1) {
                    pre.add(it.getKey().data);
                    it.setValue(2);
                    st.push(it);
                    if (it.getKey().left != null) {
                        st.push(new Pair<>(it.getKey().left, 1));
                    }
                } else if (it.getValue() == 2) {
                    in.add(it.getKey().data);
                    it.setValue(3);
                    st.push(it);
                    if (it.getKey().right != null) {
                        st.push(new Pair<>(it.getKey().right, 1));
                    }
                } else {
                    post.add(it.getKey().data);
                }


            }
            result.add(pre);
            result.add(in);
            result.add(post);
            return result;
        }


            public void printList(List<Integer> list) {
                for (int num : list) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }


    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Create object of Solution class
        Solution sol = new Solution();

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<List<Integer>> traversals = sol.preInPost(root);

        // Extracting the traversals
        List<Integer> pre = traversals.get(0);
        List<Integer> in = traversals.get(1);
        List<Integer> post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        sol.printList(pre);

        System.out.print("Inorder traversal: ");
        sol.printList(in);

        System.out.print("Postorder traversal: ");
        sol.printList(post);
    }
}
