package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle1 {
    static class Solution{
        static boolean checkForCycle(int s,ArrayList<ArrayList<Integer>> adj,
                                     boolean vis[])
        {
            Queue<Node> q =  new LinkedList<>(); //BFS
            q.add(new Node(s, -1));
            vis[s] =true;

            // until the queue is empty
            while(!q.isEmpty())
            {
                // source node and its parent node
                int node = q.peek().first;
                int par = q.peek().second;
                q.remove();

                // go to all the adjacent nodes
                for(Integer it: adj.get(node))
                {
                    if(vis[it]==false)
                    {
                        q.add(new Node(it, node));
                        vis[it] = true;
                    }

                    // if adjacent node is visited and is not its own parent node
                    else if(par != it) return true;
                }
            }

            return false;
        }

        public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
            boolean[] vis= new boolean[V];
            for(int i=0;i<V;i++) vis[i]=false;
            for(int i=0;i<V;i++){
                if(vis[i]==false){
                    if(checkForCycle(i,adj,vis)) return true;
                }
            }
            return false;
        }
        static class Node {
            int first;
            int second;
            public Node(int first, int second) {
                this.first = first;
                this.second = second;
            }
        }
    }


static class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        Solution obj = new Solution();
        boolean ans = obj.isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
}
