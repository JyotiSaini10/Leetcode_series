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

public class Problem_2095 {

    public ListNode deleteMiddle(ListNode head) {

        // If the list has only one node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer two steps ahead initially
        fast = fast.next.next;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node
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

        // Creating the linked list:
        // 1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        Problem_2095 obj = new Problem_2095();

        System.out.print("Original List: ");
        printList(head);

        head = obj.deleteMiddle(head);

        System.out.print("After Deleting Middle Node: ");
        printList(head);
    }
}