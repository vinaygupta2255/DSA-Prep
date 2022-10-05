

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

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if(list1 == null)
			return list2;

		if(list2 == null)
			return list1;

		if(list1.val <= list2.val ){
			return solve(list1, list2);
		}
		else
		{
			return solve(list2, list1);
		}
	}

	static ListNode solve(ListNode list1, ListNode list2) {

		//if only one node in first list
		if(list1.next == null){
			list1.next = list2;
			return list1;
		}

		ListNode curr1 = list1;
		ListNode next1 = curr1.next;

		ListNode curr2 = list2;
		ListNode next2 = curr2.next;

		while(next1 != null && curr2 != null) {

			if( (curr2.val >= curr1.val ) 
					&& ( curr2.val <= next1.val)) {

				curr1.next = curr2;
				next2 = curr2.next;
				curr2.next = next1;
				curr1 = curr2;
				curr2 = next2;
			}
			else {
				curr1 = next1;
				next1 = next1.next;

				if(next1 == null){
					curr1.next = curr2;
					return list1;
				}
			}

		}
		return list1;
	}
		/*
   public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode cursor1 = list1;
		ListNode cursor2 = list2;
		ListNode commonHead;

		if(list1 == null) 
			return list2;
		else if(list2 == null) 
			return list1;

		if(cursor1.val > cursor2.val) {
			commonHead = cursor2; 
			cursor2 = cursor2.next;
		}
		else {
			commonHead = cursor1; 
			cursor1 = cursor1.next;
		}

		ListNode ans = commonHead;

		while(cursor1!=null && cursor2!=null) {
			if(cursor1.val<=cursor2.val) {
				commonHead.next = cursor1;
				cursor1 = cursor1.next;
			}else {
				commonHead.next = cursor2;
				cursor2 = cursor2.next;
			}
			commonHead = commonHead.next;
		}
		if(cursor1 == null)
		{
			if(cursor2 != null)
			{
				commonHead.next = cursor2;
			}
		}
		else
		{
			commonHead.next = cursor1;
		}
		return ans;
	}*/

	}