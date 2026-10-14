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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode(0);
         temp.next = head;
      ListNode dummy = temp;
         for(int i=1; i< left; i++)
             dummy = dummy.next;

             ListNode curr = dummy.next, prev = null;
             for(int i=0; i< right-left+1; i++){
                ListNode n = curr.next;
                curr.next = prev;
                prev = curr;
                curr = n;
             }

             dummy.next.next = curr;
             dummy.next = prev;

       return temp.next;
    }
}