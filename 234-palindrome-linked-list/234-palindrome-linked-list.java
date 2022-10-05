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
    
    
    public static boolean isPalindrome(ListNode head) {
		if(head.next == null) {
			return true;
		}

		//step 1 . find Middle
		ListNode middle = getMid(head);
		//cout << "Middle " << middle.val << endl;

		//step2 . reverse List after Middle
		ListNode temp = middle.next;
		middle.next = reverse(temp);

		//step3 - Compare both halves
		ListNode head1 = head;
		ListNode head2 = middle.next;

		while(head2 != null) {
			if(head2.val != head1.val) {
				return false;
			}
			head1 = head1.next;
			head2 = head2.next;
		}

		//step4 - repeat step 2
		temp = middle.next;
		middle.next = reverse(temp);

		return true;
	}


	static ListNode getMid(ListNode head ) {
		ListNode slow = head;
		ListNode fast = head.next;

		while(fast != null && fast. next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
	
	static ListNode reverse(ListNode head) {

		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;

		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
    
/*
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			ListNode temp = slow;
			slow = slow.next;
			temp.next = prev;
			prev = temp;
		}
		//Handling for odd length linked list
		if (fast != null) slow = slow.next;
		while (prev != null && slow != null) {
			if (prev.val != slow.val) return false;
			prev = prev.next;
			slow = slow.next;
		}
		return prev == null && slow == null;
	}*/
}