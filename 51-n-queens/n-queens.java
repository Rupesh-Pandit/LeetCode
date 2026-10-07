class Solution {
    List<List<String>> ans;

    // boardPrint
    public void printBoard(String board[][]) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }

            list.add(sb.toString());
        }
        ans.add(list);
    }

    // for condition
    public boolean isSafe(String board[][], int row, int col) {
        // up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col].equals("Q"))
                return false;
        }

        // up left

        for (int i = row - 1, j = col - 1; (i >= 0 && j >= 0); i--, j--) {
            if (board[i][j].equals("Q"))
                return false;
        }

        // up right 
        for (int i = row - 1, j = col + 1; (i >= 0 && j < board.length); i--, j++) {
            if (board[i][j].equals("Q"))
                return false;
        }
        return true;
    }

    public void queen(String board[][], int row, int n) {
        // base 
        if (row == n) {
            printBoard(board);
            return;
        }

        // recursion
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {

                board[row][j] = "Q";
                queen(board, row + 1, n);
                board[row][j] = ".";
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        String board[][] = new String[n][n];
   
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "."; // empty cell
            }
        }

        
            queen(board, 0, n);
        
        return ans;
    }
}