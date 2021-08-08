package leetcode;

import java.util.PriorityQueue;

class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode head = null, prev = null;
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            if (head == null) {
                head = cur;
            } else {
                prev.next = cur;
            }
            prev = cur;
            if (cur.next != null) {
                pq.add(cur.next);
            }
        }
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