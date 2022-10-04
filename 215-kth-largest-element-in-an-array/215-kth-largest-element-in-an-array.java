class Solution {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); //using deault MinHeap

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            int temp = pq.peek();
            if (temp < nums[i]) {
                pq.remove();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}
