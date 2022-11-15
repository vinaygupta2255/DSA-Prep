class Solution {
	
	// same we can try using a arr[] only
	// Also, priorityQueue will not work as we can take head as max element but how we can 	 
	// remove the element from last window while doing window slide
    // understand this solution deeply
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		Deque<Integer> dq = new ArrayDeque<>(); 
		int[] ans = new int[nums.length-k+1];

		for(int i = 0;i<len;i++) {
		// tricky line, deleting all numbers from back of queue which are lesser than current adding element
			while(!dq.isEmpty() && nums[dq.getLast()]<=nums[i]) {
				dq.removeLast();
			}
			dq.add(i);
			if(dq.peekFirst() == i-k) {
				dq.removeFirst();
			}
			// if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
			if(i>=k-1) {
				ans[i-(k-1)] = nums[dq.peek()];
			}
		}
		return ans;
	}

}