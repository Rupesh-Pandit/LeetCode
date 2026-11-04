class Solution {
    int dp[][];

    public int path(int m, int n, int i, int j){
        if(i == m-1 && j== n-1) {
            return 1;
        }
           int right=0, down=0;

        if(dp[i][j]!= -1) return dp[i][j];
        if(i+1 <m && j< n){
            down = path(m, n, i+1, j);
        }

        if(i<m && j+1 < n){
            right= path(m, n, i, j+1);
        }

        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for(int i=0; i<m; i++)
        Arrays.fill(dp[i], -1);

       return path(m, n, 0, 0);
    }
}