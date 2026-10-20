class Solution {
    public String simplifyPath(String path) {
        String arr[]= path.split("/");

      Stack<String> s = new Stack<>();
      StringBuilder sb = new StringBuilder();
int skip=0;
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i].equals(".") || arr[i].equals("")) continue;
            else
            if(arr[i].equals("..")) {
                skip++;
            } else if(skip >0){
                skip--;
            }
            else{
                s.push(arr[i]);
                
            }

        }
      if(s.isEmpty())return "/";
        while(!s.isEmpty()){
            sb.append("/");
            sb.append(s.pop());
        }
           return sb.toString();
    }
}