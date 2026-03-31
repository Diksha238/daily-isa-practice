package Graph;

public class floodFill {
    static class Solution{
        public int[][] flood(int[][] image,int sr,int sc,int color){
            int original=image[sr][sc];
            if(original == color) return image;
            dfs(image,sr,sc,original,color);
            return image;
        }
        public void dfs(int[][]image,int i,int j,int original,int color){
            int n=image.length;
            int m=image[0].length;
            if(i<0 || j<0 || i>=n || j>=m) return ;
            if(image[i][j]!= original) return;
            image[i][j]=color;

            dfs(image,i+1,j,original,color);
            dfs(image,i-1,j,original,color);
            dfs(image,i,j+1,original,color);
            dfs(image,i,j-1,original,color);
        }
    }
    static class Main{
        public static void main(String[] args) {
            int [][] image={
                    {1,1,1},
                    {1,1,0},
                    {1,0,1}
            };
            int sr=1;
            int sc=1;
            int color=2;
            Solution sol= new Solution();
            int[][] result=sol.flood(image,sr,sc,color);
            for(int i = 0; i < result.length; i++){
                for(int j = 0; j < result[0].length; j++){
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
