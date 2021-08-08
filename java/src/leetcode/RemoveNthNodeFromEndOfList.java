package leetcode;

class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            tmp = tmp.next;
            count++;
        }
        if (n == count) {
            return head.next;
        }
        tmp = head;
        for (int i = 0; i < count - n - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }

    public static class ListNode {
    	int val;
     	ListNode next;
      	ListNode() {}
      	ListNode(int val) { this.val = val; }
      	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  	}
}