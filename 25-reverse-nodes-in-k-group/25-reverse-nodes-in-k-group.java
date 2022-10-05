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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        //base case
        if(head == null){
             return null;
         }
        
       // check length if it is < k then ignore this group
        ListNode lengthCheck = head;
        int length = 0;
        
        while(lengthCheck != null){
            lengthCheck = lengthCheck.next;
            length++;
        }
        if(length<k) return head;
        
        
      // solving 1 case of k group nodes
       ListNode prev = null;
       ListNode curr = head;
       ListNode forward = null;
       int count = 0;
        
        while(curr != null && count<k){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            count++;
        }
        
        // solving rest cases
        if(forward != null){
            head.next = reverseKGroup(forward,k);
        }
        return prev;
    }
}