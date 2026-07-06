class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map= new HashMap<>();

          for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            List<String> l = new ArrayList<>();
            if (!map.containsKey(key)) {
                l.add(s);
                map.put(key, l);
            } else {
                l = map.get(key);
                l.add(s);
            }

        }
        return new ArrayList<>(map.values());
    }
}