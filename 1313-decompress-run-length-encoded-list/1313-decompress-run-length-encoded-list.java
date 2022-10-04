class Solution {
    	public int[] decompressRLElist(int[] nums) {
		int outputArrayLength = 0;
		for(int i=0; i<nums.length; i+=2) {
			outputArrayLength = outputArrayLength+nums[i];
		}
		int[] outputArray = new int[outputArrayLength];
		for(int i = 0, j=0 ; i<nums.length ; i=i+2) {
			int freq = nums[i];
			while(freq>0) {
				outputArray[j] = nums[i+1];
				j++;
				freq--;
			}
		}
		return outputArray;
	}
}