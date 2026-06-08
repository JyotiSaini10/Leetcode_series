// 35. Search Insert Position

// Using lower bound->

class Problem_36 {
    public static int searchInsert(int[] nums, int target) {
        // int arr[size];
        // int target;
        int ans=nums.length;
        int low=0;
        int high= nums.length-1;
        while(low<=high){
            int mid= (low+high)/2;
            if(nums[mid]>= target){
                ans= mid;
                high= mid-1;
            }else{
                low= mid+1;
            }
            
        }
          return ans;    
    }

    public static void main(String[] args) {
        int nums[]= {1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }
    
}
