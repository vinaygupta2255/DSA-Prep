class Solution {
    
    public static int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for(int x : nums) sum += x;
        
             for(int i=0;i<nums.length;i++){
               if(leftSum == sum - leftSum - nums[i])  return i;                    
                leftSum += nums[i];
             }
        return -1;
    }
    // not an efficient solution T.C = O(Nsqr)
    // try Binary Search
   
    
}