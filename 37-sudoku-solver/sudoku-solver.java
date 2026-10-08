class Solution {
    public boolean isSafe(char b[][], int row, int col, char d){
        // for vertical
        for(int i =0; i< 9; i++){
            if(b[i][col]== d) return false; 
        }

        // horizontal
        for(int j=0; j<9; j++){
            if(b[row][j] == d) return false;
        }

        int sr = (row/3)*3;
        int sc = (col/3)* 3;

        for(int i=sr; i<= sr+2; i++){
            for(int j=sc; j<= sc+2; j++){
                if(b[i][j]== d) return false;
            }
        }

return true;
    }
    public boolean ss(char b[][], int row, int col){

        if(row ==9){
            return true;
        }
        int nr= row, nc= col+1;
        if(nc==9){
            nr++;
            nc=0;
        }

        if(b[row][col] != '.'){
            return ss(b, nr, nc);
        }

        for(char i='1'; i<= '9'; i++ ){
            if(isSafe(b, row, col, i)){
                b[row][col]= i;
                if(ss(b, nr, nc)) return true;;

                b[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        ss(board, 0, 0);
    }
}