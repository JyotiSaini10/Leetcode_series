class ListNode {
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

class Problem_234 {

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = reverse(head.next);
        ListNode front = head.next;

        front.next = head;
        head.next = null;

        return newNode;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverse(newHead);
        return true;
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Problem_234 obj = new Problem_234();

        System.out.println(obj.isPalindrome(head));
    }
}