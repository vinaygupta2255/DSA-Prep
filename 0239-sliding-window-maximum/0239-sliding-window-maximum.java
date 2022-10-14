class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();            
    }
}




/* my own solution which is throwing time limit exceeded

class Solution {
public static int[] maxSlidingWindow(int[] nums, int k) {
	int n = nums.length;
	Deque<Integer> dq = new ArrayDeque<>(); 
	int[] ans = new int[nums.length-k+1];int temp = 0;
	for(int i=0; i<k; i++) {
		if(nums[i] > nums[temp]) {
			temp = i;
		}
	}
	dq.addLast(temp);//adding max element of window k

	//store answer of first k size window
	if(dq.size() > 0) {
		ans[0] = nums[dq.peekFirst()];
	}
	else
	{
		ans[0] = 0;
	}

	//now process for remaining windows
	for(int i = k, j=1; i<n; i++, j++) {

		//first pop, out of window element
		if(!dq.isEmpty() && (i - dq.getFirst())>=k ) {
			dq.pop();
		}

		//then push current element
		if(dq.isEmpty()) {// push max element of window k
			int temp1 = i-k+1;
			for(int s=i-k+1; s<=i; s++) {
				if(nums[s] > nums[temp1]) {
					temp1 = s;
				}
			}
			dq.addLast(temp1);//adding max element of window k
		}else if(!dq.isEmpty() && nums[i] > nums[dq.getFirst()]) {
			dq.pop();
			dq.push(i);
		}

		// put in ans
		if(dq.size() > 0) {
			ans[j] = nums[dq.getFirst()];
		}
		else
		{
			ans[j] = 0;
		}
	}
	return ans;
}
}
*/