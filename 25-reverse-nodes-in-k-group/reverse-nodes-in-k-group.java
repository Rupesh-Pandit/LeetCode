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
        ListNode temp = head;

        int count =0;
        while(count < k){
            if (temp == null) return head;
            temp = temp.next;
            count++;
        }
        ListNode prev = reverseKGroup(temp, k);

        ListNode curr = head;
        count =0;
        while(count <k){
            ListNode n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
            count++;
        }
        return prev;

    }
}