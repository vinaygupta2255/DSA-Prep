class Solution {
 
    /* //worst approach
    public void moveZeroes(int[] nums) {
        // bubble sort
         for(int i=0; i<nums.length-1; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(nums[j]==0){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    */
public static int[] moveZeroes(int[] nums) {
		//move all non zeros to left by comparing next element with moved non zero value index
		int i = 0; // swapped non-zero index
		for(int j = 0; j<nums.length; j++) {
			if(nums[j] != 0){// agar 0 nahi hai koi value hai, last time wale index se swap kardo bcz non-zero ko left me rakhna hai. lets say for 12, swap it to left with last ith index bcz we need non-zero in left.
				swap(j, i, nums); 
				i++;
			}
		}
		return nums;
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}