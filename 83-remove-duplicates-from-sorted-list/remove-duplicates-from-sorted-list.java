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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int prev = Integer.MAX_VALUE;

        while(head != null){
           if(head.val != prev && head != null ){
            temp.next = head;
            prev  = head.val;

            temp = temp.next;
            head = head.next;
           } else {
            prev = head.val;
            head = head.next;
           }
        }
           temp.next = null ;
           return dummy.next;
    }
}