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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;

        if(head == null || head.next == null) return head;

        int count =0;
        while(count < 2) {
            temp = temp.next;
            count ++;
        }

        ListNode prev = swapPairs(temp);

        ListNode curr = head;
        count =0;
        while(count < 2){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr =n;

            count ++;
        }
        return prev;
    }
}