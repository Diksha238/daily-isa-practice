package Graph;

import java.util.ArrayList;

public class dfsTraversal {
    static class Solution{
        public void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ls){
            vis[node]=true;
            ls.add(node);
            for(Integer it:adj.get(node)){
                if(!vis[it]){
                    dfs(it,vis,adj,ls);
                }
            }
        }
        public ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){
            boolean vis[]= new boolean[V];
            ArrayList<Integer> ls= new ArrayList<>();
            dfs(1,vis,adj,ls);
            return ls;
        }
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V=9;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,5);
        addEdge(adj,2,6);
        addEdge(adj,3,4);
        addEdge(adj,3,7);
        addEdge(adj,4,8);
        addEdge(adj,7,8);
        Solution obj= new Solution();
        ArrayList<Integer> result=obj.dfsOfGraph(V,adj);
        System.out.println("DFS Traversal");
        for(int node:result) {
            System.out.println(node + "");
        }
    }
}
