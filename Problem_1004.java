public class Problem_1004 {

    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, zeros = 0, maxLen = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Problem_1004 solution = new Problem_1004();

        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        int result = solution.longestOnes(nums, k);
        System.out.println("Longest subarray length: " + result);
    }
}