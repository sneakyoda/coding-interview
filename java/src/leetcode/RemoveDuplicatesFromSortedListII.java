package leetcode;

class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(0, head), prev = sentinel;
        ListNode begin = head, end = head;
        while (begin != null) {
            int count = 0;
            while (end != null && (begin == end || end.val == begin.val)) {
                end = end.next;
                count++;
            }
            if (count == 1) {
                prev.next = begin;
                prev = begin;
            } else {
                prev.next = null;
            }
            begin = end;
        }
        return sentinel.next;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}