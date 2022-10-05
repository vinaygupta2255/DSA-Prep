/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public static ListNode middleNode(ListNode head) {
		//check for 0 or 1 element
        if(head==null || head.next==null){
			return head;
         }

        //check for 2 elements
        if(head.next.next==null){
			return head.next;
         }
        
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null) {
			fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
		}
		return slow;
	}
}