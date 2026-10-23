class Solution {
    public int sortPermutation(int[] nums) {
        boolean isSorted = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                isSorted = false;
        }
        if (isSorted)
            return 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                list.add(nums[i]);
        }

        int ans = list.get(0);
        int j = 0;
       
        while (j < list.size()) {
            ans = ans & list.get(j);
            j++;
        }

        return ans;
    }
}