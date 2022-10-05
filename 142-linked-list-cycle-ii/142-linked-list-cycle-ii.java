/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

	//floyds detection algorithm + single move of slow and fast
	public static ListNode detectCycle(ListNode head) {
	
		if(head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		while(slow != null && fast != null){
			fast = fast.next;
			if(fast !=null){
				fast = fast.next;
			}
			slow = slow.next;

			if(slow == fast){
				break;
			}
		}

		slow = head;
		if(fast==null || fast.next==null) 
            return null;

		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}

		return slow;
	}

	/*
	public static ListNode detectCycle(ListNode head) {
		ListNode slowPointer = head;
		ListNode fastPointer = head;

		do {
			if(slowPointer == null ||fastPointer == null || fastPointer.next == null) {
				return null;
			}
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

		}while(slowPointer!=fastPointer);

		slowPointer = head;
		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		return slowPointer;
	}
	 */
}