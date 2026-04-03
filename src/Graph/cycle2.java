package Graph;

import java.util.ArrayList;

public class cycle2 {
    static class Solution{
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
            int[] vis= new int [V];
            for(int i=0;i<V;i++){
                if(vis[i]==0){
                    if(dfs(i,-1,vis,adj))return true;
                }

            }
            return false;

        }
        private boolean dfs(int node,int parent,int[]vis,ArrayList<ArrayList<Integer>> adj){
            vis[node]=1;
            for( int it: adj.get(node)){
                if(vis[it]==0){
                    if(dfs(it,node,vis,adj)) return true;
                }
                if(it != parent){
                    return true;
                }
            }
            return false;
        }
    }
    static class Main {
        public static void main(String[] args) {
            // Example: Graph with 5 nodes and a cycle
            int V = 5;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

            // Add edges
            adj.get(0).add(1);
            adj.get(1).add(0);
            adj.get(1).add(2);
            adj.get(2).add(1);
            adj.get(2).add(3);
            adj.get(3).add(2);
            adj.get(3).add(4);
            adj.get(4).add(3);
            adj.get(4).add(1);

            Solution sol = new Solution();
            if (sol.isCycle(V, adj))
                System.out.println("Cycle detected");
            else
                System.out.println("No cycle found");
        }
    }
}
