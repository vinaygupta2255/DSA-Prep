class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int s = 0;
		int sum = 0;
		for(int i = 0;i<weights.length;i++) {
			sum+=weights[i];
		}
		int e = sum;
		int mid = s+(e-s)/2;
		int ans = -1;
		while(s<=e) {
			if(isPossibleSolution(weights, weights.length, days, mid)) {
				ans = mid;
				e = mid-1;
			}else {
				s = mid+1;
			}
			mid = s+(e-s)/2;
		}
		return ans; 
    }
    
    
	private static boolean isPossibleSolution(int[] weights, int n, int m, int mid) {
		int weightcount = 0;
		int dayscount = 1; 
		for(int i = 0;i<n;i++) {
			if(weightcount + weights[i] <=mid) {
				weightcount+=weights[i];
			}else {
				dayscount++;
				if(dayscount>m ||  weights[i] > mid) {
					return false;
				}
				weightcount = 0;
				weightcount+=weights[i];
			}
		}
		return true;
	}

}