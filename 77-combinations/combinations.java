class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void rec(int []arr, int k, List<Integer> list, int st){
        if(k==0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k<0) return ;
        
        for(int i=st; i<arr.length; i++){
            list.add(arr[i]);
            rec(arr, k-1, list, i+1 );
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        int []arr = new int[n];
        for(int i=0; i< n; i++) arr[i] = i+1;

        rec(arr, k, new ArrayList<>(), 0);
        return ans;
    }
}