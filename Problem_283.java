// 283. Move Zeroes

// Given an integer array nums, move all 0's to the end of it while maintaining
// the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

class Problem_283{
        public static void moveZeroes(int[] nums) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }
        }        
    }

    public static void main(String[] args) {
        int nums[]= {4,2,0,5,1,0,0,6};
        moveZeroes(nums);

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
        }
    }
}