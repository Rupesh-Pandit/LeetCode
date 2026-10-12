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
    public boolean isPalindrome(ListNode head) {
        ListNode slow= head, fast= head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode curr = slow.next,prev = null, n;

        while( curr != null ){
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        slow.next = null;
        ListNode lh = head;
        ListNode rh = prev;

        while(lh != null && rh != null){

            if(lh.val != rh.val) return false ;
            ListNode lhead = lh.next;
            ListNode rhead = rh.next;

            lh.next = rh;
            rh.next = rhead;

            lh = lhead; 
            rh = rhead;
        }
        return true;
    }
}