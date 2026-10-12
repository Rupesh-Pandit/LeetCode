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
    public void reorderList(ListNode head) {
        
        ListNode slow = head ,fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
          // making first half
        slow.next = null;

        ListNode prev = null, n;

        while(curr != null){
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
      

        // now zig zag form
        ListNode lh = head, rh = prev;
          ListNode lhead, rhead;
        while(lh != null && rh != null){
            lhead = lh.next;
            rhead = rh.next;
            
            lh.next = rh;
            rh.next = lhead;
            lh = lhead;
            rh = rhead;
        }

    }
}