package tree;

import java.util.*;

public class NodesAtDistanceK {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    static class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            if (root == null) return new ArrayList<>();
            Map<TreeNode, TreeNode> parentMap = new HashMap<>();
            mapParents(root, parentMap);
            return bfsFromTarget(target, parentMap, k);
        }

        private void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }

        private List<Integer> bfsFromTarget(TreeNode target, Map<TreeNode, TreeNode> parentMap, int k) {
            Queue<TreeNode> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            queue.offer(target);
            visited.add(target);

            int currentLevel = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                if (currentLevel++ == k) break;

                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null && !visited.contains(node.left)) {
                        visited.add(node.left);
                        queue.offer(node.left);
                    }
                    if (node.right != null && !visited.contains(node.right)) {
                        visited.add(node.right);
                        queue.offer(node.right);
                    }
                    if (parentMap.containsKey(node) && !visited.contains(parentMap.get(node))) {
                        visited.add(parentMap.get(node));
                        queue.offer(parentMap.get(node));
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                result.add(queue.poll().val);
            }

            return result;
        }
    }

    static public class Main {
        public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(5);
            root.right = new TreeNode(1);
            root.left.left = new TreeNode(6);
            root.left.right = new TreeNode(2);
            root.left.right.left = new TreeNode(7);
            root.left.right.right = new TreeNode(4);
            root.right.left = new TreeNode(0);
            root.right.right = new TreeNode(8);

            // Node with value 5
            TreeNode target = root.left;
            int k = 2;

            Solution sol = new Solution();
            List<Integer> result = sol.distanceK(root, target, k);

            // Print the result
            for (int val : result) {
                System.out.print(val + " ");
            }
        }
    }
}

