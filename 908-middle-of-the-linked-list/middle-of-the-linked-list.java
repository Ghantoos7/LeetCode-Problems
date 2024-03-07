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
    public ListNode middleNode(ListNode head) {
        
        ListNode current = head;
        int size = 0;

        while (current != null){
            size++;
            current = current.next;
        }
        current = head;

        for (int i = 0; i < size / 2; i++){
            current = current.next;
        }

        return current;




    }
}