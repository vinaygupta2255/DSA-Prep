class Solution {
    
	public int removeDuplicates(int[] nums) {


		int index = 1;
		for(int i=index;i<nums.length;i++){

			if(nums[i] > nums[index-1]) {
				nums[index++] = nums[i];
			}

		}
		return index;

	}
}