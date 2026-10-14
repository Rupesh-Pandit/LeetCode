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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;

        int count =0;
        ListNode curr = head;
        while(curr != null) {
            curr = curr.next;
            count++;
        }
      ListNode temp = head;
      while(temp.next != null) temp = temp.next;


        k = k%count;
        if(k == 0) return head;

        
      temp.next =head; 
        temp = head;

        for(int i=1; i< count-k; i++){
          temp = temp.next;
        }
         head=temp.next;
        temp.next = null;
        return head;
    }
}