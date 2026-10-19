class Solution {
    public class Pair{
        int i, j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public class Entry{
        Pair pair;
        int time;
        Entry(Pair pair, int time){
            this.pair = pair;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Entry> q  = new LinkedList<>();
       int n = grid.length;
       int m = grid[0].length;
       boolean visit[][] = new boolean [n][m];
        
       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid[i][j] == 2){
                q.add(new Entry(new Pair(i,j), 0));
                 visit[i][j] = true;
            }
        }
       } 

int ans = 0;
       

       while(!q.isEmpty()){
        Entry e = q.poll();
        int x = e.pair.i;
        int y = e.pair.j;
        int t = e.time;
         ans = Math.max(ans, t);

         // up
         if(x-1 >=0 && !visit[x-1][y] && grid[x-1][y] == 1){
            grid[x-1][y]= 2;
            q.add(new Entry(new Pair(x-1, y), t+1));
            visit[x-1][y]= true;
         }

         // down
         if(x+1 <n && !visit[x+1][y] && grid[x+1][y] == 1){
            grid[x+1][y]= 2;
            q.add(new Entry(new Pair(x+1, y), t+1));
            visit[x+1][y]=true;
         }

         // left
         if(y-1 >=0 && !visit[x][y-1] && grid[x][y-1] == 1){
            grid[x][y-1]= 2;
            q.add(new Entry(new Pair(x, y-1), t+1));
            visit[x][y-1]= true;
         }
         if(y+1 < m && !visit[x][y+1] && grid[x][y+1] == 1){
            grid[x][y+1]= 2;
            q.add(new Entry(new Pair(x, y+1), t+1));
            visit[x][y+1]= true;
         }
       }

       for(int i=0; i< n; i++)
       for(int j=0; j<m; j++)
        if(grid[i][j]==1)return -1;

       return ans;
    }
}