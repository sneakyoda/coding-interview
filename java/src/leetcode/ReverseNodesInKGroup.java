package leetcode;

class ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null && count != k) {
            count++;
            tmp = tmp.next;
        }
        if (count != k) {
            return head;
        }
        ListNode newHead = reverseList(head, k);
        ListNode nextRecursiveNode = tmp;
        head.next = reverseKGroup(nextRecursiveNode, k);
        return newHead;
    }
    
    private ListNode reverseList(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newHead = reverseList(head.next, k - 1);
        head.next.next = head;
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