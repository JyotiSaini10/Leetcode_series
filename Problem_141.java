// 141. Linked List Cycle(detect cycle)

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Problem_141 {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Problem_141 sol = new Problem_141();

        // Create nodes
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        // Link nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Create cycle: n4 -> n2
        n4.next = n2;

        System.out.println(sol.hasCycle(n1)); // true

        // Non-cyclic list
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        System.out.println(sol.hasCycle(a)); // false
    }
}