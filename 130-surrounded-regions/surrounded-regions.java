class Solution {

    public void change(char arr[][], int i, int j){
        arr[i][j]= '#';

        // up
        if(i-1 >=0 && arr[i-1][j] == 'O')
        change(arr,i-1, j );

        // down
        if(i+1 < arr.length && arr[i+1][j] == 'O')
        change(arr, i+1, j);

        // left
        if(j-1>=0 && arr[i][j-1] == 'O')
        change(arr, i, j-1);

        // right 
        if(j+1 < arr[0].length && arr[i][j+1] == 'O')
        change(arr, i, j+1);

        return ;

    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int j=0; j<m; j++ ){
            if(board[0][j] == 'O')
            change(board, 0, j);
        }
        for(int j=0; j<m; j++ ){
            if(board[n-1][j] == 'O')
            change(board, n-1, j);
        }

        for(int i =0; i< n; i++){
            if(board[i][0] == 'O')
            change(board, i, 0);
        }
        for(int i =0; i< n; i++){
            if(board[i][m-1] == 'O')
            change(board, i, m-1);
        }

        for(int i=0; i< n; i++){
            for(int j=0; j< m; j++){
                if(board[i][j] == 'O')
                board[i][j]= 'X';
                else if(board[i][j] == '#')
                board[i][j] = 'O';
            }
        }

    }
}