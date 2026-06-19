// 142. Linked List Cycle II(finding the starting point where the loop starts)

    class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Problem_142 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // start of cycle
            }
        }

        return null; // no cycle
    }

    public static void main(String[] args) {

        Problem_142 obj = new Problem_142();

        // Create list: 3 -> 2 -> 0 -> -4
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        // Create cycle: -4 -> 2
        n4.next = n2;

        ListNode cycleStart = obj.detectCycle(n1);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found");
        }

        // Test case without cycle
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        cycleStart = obj.detectCycle(a);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found");
        }
    }
}
    

