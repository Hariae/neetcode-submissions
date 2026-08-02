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

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        ListNode head = null, result = null;

        if (lists.length == 0) return result;

        for (int i=0;i<lists.length;i++) {
            ListNode curr = lists[i];
            if (curr != null) {
                pq.offer(curr);
            }
        }

        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            System.out.println(curr.val);
            if (result != null) {
                result.next = curr;
            } else {
                head = curr;
            }

            result = curr;            
            //result.next = null;
            if (curr.next != null) {
                pq.offer(curr.next);
            }
            
            
            
        }

        return head;

    }
}
