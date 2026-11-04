class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    long leftSum = 0;
    long rightSum = 0;

    int leftSize = 0;
    int rightSize = 0;

    long[][] dp;
    long[] cost;

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        cost = new long[n];

        buildCost(nums, x);

        dp = new long[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, k, x, n);
    }

    private long solve(int i, int k, int x, int n) {

        if (k == 0) {
            return 0;
        }

        if (i >= n) {
            return Long.MAX_VALUE / 2;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        long skip = solve(i + 1, k, x, n);

        long take = Long.MAX_VALUE / 2;

        if (i + x <= n) {
            take = cost[i] + solve(i + x, k - 1, x, n);
        }

        return dp[i][k] = Math.min(skip, take);
    }

    private void buildCost(int[] nums, int x) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            addNum(nums[i]);

            if (i >= x) {
                removeNum(nums[i - x]);
            }

            if (i >= x - 1) {

                long median = left.lastKey();

                cost[i - x + 1] =
                        median * leftSize - leftSum
                      + rightSum - median * rightSize;
            }
        }
    }

    private void addNum(int num) {

        if (leftSize == 0 || num <= left.lastKey()) {

            left.put(num, left.getOrDefault(num, 0) + 1);
            leftSum += num;
            leftSize++;

        } else {

            right.put(num, right.getOrDefault(num, 0) + 1);
            rightSum += num;
            rightSize++;
        }

        balance();
    }

    private void removeNum(int num) {

        if (left.containsKey(num)) {

            remove(left, num);
            leftSum -= num;
            leftSize--;

        } else {

            remove(right, num);
            rightSum -= num;
            rightSize--;
        }

        balance();
    }

    private void balance() {

        while (leftSize < rightSize) {

            int val = right.firstKey();

            remove(right, val);
            rightSum -= val;
            rightSize--;

            left.put(val, left.getOrDefault(val, 0) + 1);
            leftSum += val;
            leftSize++;
        }

        while (leftSize > rightSize + 1) {

            int val = left.lastKey();

            remove(left, val);
            leftSum -= val;
            leftSize--;

            right.put(val, right.getOrDefault(val, 0) + 1);
            rightSum += val;
            rightSize++;
        }
    }

    private void remove(TreeMap<Integer, Integer> map, int num) {

        int freq = map.get(num);

        if (freq == 1) {
            map.remove(num);
        } else {
            map.put(num, freq - 1);
        }
    }
}