public class Problem_83 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Delete duplicates from sorted linked list
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;

        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    // Create linked list from array
    public static ListNode createList(int[] arr) {

        if (arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;

        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" -> ");

            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5};

        ListNode head = createList(arr);

        System.out.print("Original List: ");
        printList(head);

        head = deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}