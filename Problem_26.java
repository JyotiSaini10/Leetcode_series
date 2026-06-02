public class Problem_26 {
        public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;        
    }

    public static void main(String[] args) {
        int nums[]= {3,4,2,6,1,7,2};
        System.out.println(removeDuplicates(nums));
    }
}
