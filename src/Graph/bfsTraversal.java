package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfsTraversal {
    static class Solution{
        public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj){
            ArrayList<Integer> bfs=new ArrayList<>();
            boolean vis[]=new boolean[V];
            vis[0]=true;
            Queue<Integer> q= new LinkedList<>();
            q.add(0);
            while(!q.isEmpty()){
                Integer node = q.poll();
                bfs.add(node);
                for(Integer it: adj.get(node)){
                    if(vis[it]==false){
                        vis[it]=true;
                        q.add(it);
                    }
                }
            }
            return bfs;

        }
    }
    static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        Solution obj=new Solution();
        ArrayList<Integer> result=obj.bfs(V,adj);
        System.out.println("BFS Traversal:");
        for(int node:result){
            System.out.println(node + "");
        }

    }
}
