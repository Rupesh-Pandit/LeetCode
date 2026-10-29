class TreeAncestor {
   int table[][];
   int max;
    public TreeAncestor(int n, int[] parent) {
        int len=parent.length;
        max=17;
       table =new int [max][len];

        for(int i=0; i< len;i++){
            table[0][i] =parent[i];
        }

        for(int i=1; i<max; i++){
            for(int j=0; j<len; j++){
                int par =table[i-1][j];
                if(par ==-1){
                    table[i][j]=-1;
                }else{
                    table[i][j] = table[i-1][par];
                }
            }
        }
    }
    
  public int par(int node, int k){
    for(int i=0;i<max && node!=-1;i++){
        int mask=(1<<i);

        if((k & mask)!=0){
            node =table[i][node];
        }
    }

    return node;

  }
    public int getKthAncestor(int node, int k) {
        return par(node, k);
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */