class Solution {
    public boolean rec(int arr[][], int i, int j,int k, int n){

         if(k == n*n -1) return true;

        if( (i-2 >=0 && j-1>=0) &&   arr[i-2][j-1] == k+1) return rec(arr, i-2, j-1, k+1, n);
        if((i-2 >= 0 && j+1 < n)  && arr[i-2][j+1] == k+1) return rec(arr, i-2, j+1, k+1, n);
           
        if((i-1 >= 0 && j-2 >= 0) && arr[i-1][j-2] == k+1  ) return rec(arr, i-1, j-2, k+1, n);
        if((i+1 < n && j-2 >= 0)  && arr[i+1][j-2] == k+1  ) return rec(arr, i+1, j-2, k+1, n);

        if((i-1 >=0 && j+2 < n) && arr[i-1][j+2] == k+1 ) return rec(arr, i-1, j+2, k+1, n);    
        if((i+1 < n && j+2 < n) && arr[i+1][j+2] == k+1   ) return rec(arr, i+1, j+2, k+1, n);    

        if( (i+2 < n && j-1 >= 0) && arr[i+2][j-1] == k+1 ) return rec(arr, i+2, j-1, k+1, n);    
        if((i+2 < n && j+1 < n) && arr[i+2][j+1] == k+1   ) return rec(arr, i+2, j+1, k+1,n);    
            
            return false;
    }
    public boolean checkValidGrid(int[][] grid) {
        int n= grid.length;
       
       if(grid[0][0] != 0) return false;
                if( !rec(grid, 0, 0,0, n))
                   return false;
                
        return true;
    }
}