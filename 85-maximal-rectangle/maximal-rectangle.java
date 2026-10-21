class Solution {
  public int largestArea(int arr[]){
          Stack<Integer> s = new Stack<>();
        int l[]= new int[arr.length];
        int r[]= new int[arr.length];

        for(int i=0; i< arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()]>= arr[i])
            s.pop();

            l[i] = s.isEmpty() ?-1:s.peek();
            s.push(i);
        }
        s = new Stack<>();
        for(int i=arr.length-1; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()]>= arr[i])
            s.pop();

            r[i] = s.isEmpty() ? arr.length : s.peek();
            s.push(i);
        }
        int ans =0;
        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans, (r[i]-l[i]-1)*arr[i]);
        }
        return ans;
   }
    public int maximalRectangle(char[][] matrix) {
        int arr[]= new int[matrix[0].length];
int ans =0;
        for(int i=0; i< matrix.length; i++){
             for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]== '1') arr[j]++;
                else arr[j]=0;
             }
             ans = Math.max(ans, largestArea(arr));
        }

       return ans;
        
    }
}