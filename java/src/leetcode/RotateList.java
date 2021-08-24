package leetcode;

class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if (null == head) {
            return head;
        }
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }
        cur.next = head;
        k = count - k % count;
        int i = 1;
        while (i != k) {
            head = head.next;
            i++;
        }
        ListNode ret = head.next;
        head.next = null;
        return ret;
    }

    public class ListNode {
     	int val;
      	ListNode next;
      	ListNode() {}
      	ListNode(int val) { this.val = val; }
      	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 	}
}