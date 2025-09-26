class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nums[i] + nums[j];
                int k = search(sum, nums);
                ans += Math.max(0, k - j);
            }
        }
        return ans;
    }

    public static int search(int val, int[] nums) {
        int low = 0, high = nums.length - 1, res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < val) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
