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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }

        System.out.println(count);

        int index = 0;
        curr = head;
        ListNode prev = null;

        if (count == n) {
            return head.next;
        }

        while(curr != null) {
            index++;
            if (count - index == n) {
                curr.next = curr.next.next;
                return head;
            } 

            curr = curr.next;
            
        }

        return head;

    }
}
