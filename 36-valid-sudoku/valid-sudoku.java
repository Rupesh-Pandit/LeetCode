class Solution {

    public boolean isSafe(char board[][], int row, int col, char d){
        // vertical 
        for(int i=0; i< 9; i++){
            if(i!= row && board[i][col] == d) return false;

        } 

        for(int j=0; j<9; j++) {
            if(j != col && board[row][j] == d) return false;
        }
        // 3*3 cell
        int sr = (row/3)*3;
        int sc= (col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j< sc+3; j++){
                if ( (i!= row || j!= col) && board[i][j] == d) return false;
            }
        }
        return true;
    }

    public boolean ss(char board[][], int row, int col){
        if(row == 9) return true;

        int nr=row, nc=col+1;
        if(nc==9){
            nr++;
            nc=0;
        }

        if(board[row][col] == '.'){
            return ss(board, nr, nc);
        }

        if(isSafe(board, row, col, board[row][col]))
            return ss(board, nr, nc);
           
           return false;
    }
    public boolean isValidSudoku(char[][] board) {
        return ss(board, 0, 0);
    }
}