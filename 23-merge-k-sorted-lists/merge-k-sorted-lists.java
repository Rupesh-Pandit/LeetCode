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
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> allValues = new ArrayList<>();

        for(int i =0; i< lists.length; i++){

            ListNode temp = lists[i];
            while(temp != null){
            allValues.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(allValues);

        ListNode newList = new ListNode(0);
        ListNode temp = newList;
        
        int count =0;
        while(count < allValues.size()){
            temp.next = new ListNode(allValues.get(count));
            temp = temp.next;
            count ++;
        }
        return newList.next;
    }
}