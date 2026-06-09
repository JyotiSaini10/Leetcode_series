public class Problem_81 {
    public static boolean  search(int[] nums, int target) {
        int low=0;
        int high= nums.length-1;

        while(low<= high){
            int mid= (low+high)/2;

            if(nums[mid]== target){
                return true;
            }

            if(nums[low]==nums[mid] && nums[mid]== nums[high]){
                high= mid-1;
                low= mid+1;
                continue;
            }

            if(nums[low]<= nums[mid]){
                if(nums[low]<= target && target< nums[mid]){
                    high= mid-1;
                }else{
                    low= mid+1;
                }
            }else{
                if(nums[mid]< target && target<= high){
                        low= mid+1;
                }else{
                    high= mid-1;
                }

            }

            
        }
        return false;
        
    }

    public static void main(String[] args) {
        int nums[]= {3,4,5,3,3,3,3};
        System.out.println(search(nums, 3));
    }
}
