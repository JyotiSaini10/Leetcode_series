

public class Problem_33 {
     public static int search(int[] nums, int target) {

            int start=0;
            int end = nums.length-1;

            while(start<= end){
                int mid= start+(end-start)/2;
                if(nums[mid]==target){
                    return mid;
                }

                if(nums[start]<= nums[mid]){
                    if(nums[start]<= target && target < nums[mid]){
                        end= mid-1;
                    }else{
                        start= mid+1;
                    }
                }else{
                    if(nums[mid]< target && target<= nums[end]){
                        start= mid+1;
                    }else{
                        end= mid-1;
                    }
                }
            }
            return -1;
    }

    public static void main(String[] args) {
        
        int nums[]= {2,3,4,5,0,1};
        System.out.println(search(nums, 3));
    }
}
