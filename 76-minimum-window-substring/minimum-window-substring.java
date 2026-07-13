class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            smap.put(rightChar, smap.getOrDefault(rightChar, 0) + 1);

            if (tmap.containsKey(rightChar) && smap.get(rightChar) <= tmap.get(rightChar)) {
                count--;
            }


            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    ans = s.substring(left, right + 1);
                }

                char leftChar = s.charAt(left);
                smap.put(leftChar, smap.get(leftChar) - 1);

                if (tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
                    count++;
                }
                left++;

            }
        }
        return ans;
    }
}