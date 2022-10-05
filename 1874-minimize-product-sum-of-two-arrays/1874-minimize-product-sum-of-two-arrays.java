class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        // solution using priority queue
        //sort nums1 in ascending order
        Arrays.sort(nums1);
        
        //sort nums2 in descneding order using PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums2)
            pq.add(num);
        
        int ans = 0;
        
        for(int index = 0; index < nums2.length; index++){
            ans += nums1[index] * pq.poll();
        }
     
        return ans;
    }
// T.C = O(nlogn), S.C = O(n)
}