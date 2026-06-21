class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Problem_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast becomes null, remove the head node
        if (fast == null) {
            return head.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return head;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        Problem_19 obj = new Problem_19();

        System.out.print("Original List: ");
        printList(head);

        head = obj.removeNthFromEnd(head, n);

        System.out.print("After Removing " + n + "th Node From End: ");
        printList(head);
    }
}