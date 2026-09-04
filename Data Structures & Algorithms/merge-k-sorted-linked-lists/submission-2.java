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

        if (lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
            
        }


        ListNode resultHead = null;
        ListNode curr = resultHead;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (curr == null) {                
                curr = new ListNode(node.val);
                resultHead = curr;                
            } else {
                curr.next = new ListNode(node.val);
                curr = curr.next;
            }
            
            if (node.next != null) {
                pq.add(node.next);
            }            

        }

        return resultHead;


    }
}
