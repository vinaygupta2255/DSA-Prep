class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int arraySum = 0;
		for(int i=0;i<arr.length;i++){
			int temp = 0;
			for(int j=i;j<arr.length;j++) {
				temp = temp + arr[j];
				if((j-i+1)%2==1)
					arraySum = arraySum+temp;
			}
		}
		return arraySum;
    }
}