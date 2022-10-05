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
    
    public static ListNode addTwoNumbers(ListNode first, ListNode second) {
		//step 1 -  reverse input LL
		first = reverse(first);
		second = reverse(second);

		//step2 - add 2 LL
		ListNode ans = add(first, second);

		//step 3 
		ans = reverse(ans);

		return ans;
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

	static void insertAtTail(ListNode head, ListNode tail, int val) {

		ListNode temp = new ListNode(val);
		//empty list
		if(head == null) {
			head = temp;
			tail = temp;
			return;
		}
		else
		{
			tail.next = temp;
			tail = temp;
		}
	}

	 static ListNode add(ListNode first, ListNode second) {
		int carry = 0;

		ListNode ansHead = null;
		ListNode ansTail = null;

		while(first != null || second != null || carry != 0) {

			int val1 = 0;
			if(first != null)
				val1 = first.val;

				int val2 = 0;
				if(second !=null)
					val2 = second.val;


					int sum = carry + val1 + val2;

					int digit = sum%10;

					//create node and add in answer Linked List
					/* insertAtTail(ansHead, ansTail, digit); */
					ListNode temp = new ListNode(digit);
					//empty list
					if(ansHead == null) {
						ansHead = temp;
						ansTail = temp;
					}
					else
					{
						ansTail.next = temp;
						ansTail = temp;
					}
					
					

					carry = sum/10;
					if(first != null)
						first = first.next;

						if(second != null)
							second = second.next;
		}
		return ansHead;
	}
    
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
		l2 = reverse(l2);
		
		int sum = 0;
		ListNode head = null;
		while (l1 != null || l2 != null || sum != 0) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			ListNode node = new ListNode(sum % 10);
			sum = sum / 10;
			node.next = head;
			head = node;
		}
		return head;
    }
    
    private ListNode reverse(ListNode node) {
		ListNode cur = node;
		ListNode prev = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}*/
}