package leetcode;

class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head, tmp = head.next;
        while (tmp != null) {
            if (tmp.val != prev.val) {
                prev.next = tmp;
                prev = tmp;
            } else {
                prev.next = null;
            }
            tmp = tmp.next;
        }
        return head;
    }

    class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}