/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.value = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        head = reverseList(head);

        ListNode currentNode = head;
        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (currentNode.val > nextNode.val) {
                currentNode.next = nextNode.next;
            } else {
                currentNode = nextNode;
            }
            nextNode = nextNode.next;
        }

        head = reverseList(head);

        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
