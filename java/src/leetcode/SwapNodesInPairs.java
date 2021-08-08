package leetcode;

class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextRecursiveNode = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = swapPairs(nextRecursiveNode);
        return newHead;
    }

    public static class ListNode {
    	int val;
     	ListNode next;
      	ListNode() {}
      	ListNode(int val) { this.val = val; }
      	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  	}
}