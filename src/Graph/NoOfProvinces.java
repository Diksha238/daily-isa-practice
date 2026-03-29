package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class NoOfProvinces {
    static class Solution{
        public int numberProvinces(int[][] isConnected){
            int v= isConnected.length;
            ArrayList<ArrayList<Integer>> adjLs=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<v;i++){
                adjLs.add(new ArrayList<>());
            }
            for(int i=0;i<v;i++){
                for(int j=0;j<v;j++){
                    if(isConnected[i][j]==1 && i!=j){
                        adjLs.get(i).add(j);
                        adjLs.get(j).add(i);
                    }
                }
            }
            int[] vis=new int[v];
            int cnt=0;
            for(int i=0;i<v;i++){
                cnt++;
                dfs(i,adjLs,vis);
            }
            return cnt;
        }
        public static void  dfs(int node,ArrayList<ArrayList<Integer>> adjLs,int vis[]){
            vis[node]=1;
            for(Integer it: adjLs.get(node)){
                if(vis[it]==0){
                    dfs(it,adjLs,vis);
                }
            }

        }
    }
    static  class Main {

        public static void main(String[] args) {
            // Example input (you can change this)
            int[][] isConnected = {
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1}
            };

            Solution obj = new Solution();
            int result = obj.numberProvinces(isConnected);

            System.out.println("Number of Provinces: " + result);
        }
    }
}
