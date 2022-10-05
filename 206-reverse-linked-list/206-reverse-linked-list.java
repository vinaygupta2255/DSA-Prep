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
    
    //Solution-2 : using recursion
    public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) 
			return head;

		ListNode prev = null;
		ListNode curr = head;
        return solve(prev, curr);
    }
	
   ListNode solve(ListNode prev, ListNode curr){
        
        if(curr == null)
            return prev;
        
        ListNode forward = curr.next;
        curr.next = prev;
        prev = curr;
        curr = forward;
        return solve(prev, curr);
    }
    
    //Solution-1 : using while loop
	public ListNode reverseList1(ListNode head) {
		if(head == null || head.next == null) 
			return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode forward = null;

		while (curr!=null) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
		}
		return prev;
	}
}