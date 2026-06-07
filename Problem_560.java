// 560. Subarray Sum Equals K
// Using HashMap->(Prifix sum)


import java.util.*;

class Problem_560 {

    public static int subarraySum(int[] nums,
                           int k) {

        Map<Integer, Integer> map =
            new HashMap<>();

        int count = 0;
        int sum = 0;

        // Empty prefix sum
        map.put(0, 1);

        for (int num : nums) {

            sum += num;

            int target = sum - k;

            if (map.containsKey(target)) {

                count += map.get(target);
            }

            map.put(sum,
                    map.getOrDefault(sum, 0)
                    + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int nums[]={1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(subarraySum(nums, 3));
    }
}