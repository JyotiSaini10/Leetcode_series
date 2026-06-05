public class Problem_53{
public static int maxSubArray(int[] nums) {
        int maxsum= nums[0];
        int currSum=0;

        for(int num: nums){
            if(currSum<0){
                currSum=0;
            }
                currSum+= num;
            
                maxsum= Math.max(maxsum, currSum);
        }
        
        return maxsum;
    }

    public static void main(String[] args) {
        int nums[]={-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSubArray(nums));
    }
}
