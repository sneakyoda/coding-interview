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
class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adder = 0;
        ListNode dummy = new ListNode(), tmp = dummy;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + adder;
            adder = sum / 10;
            sum = sum % 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (adder == 1) {
            tmp.next = new ListNode(1);
        }
        return dummy.next;
    }
}