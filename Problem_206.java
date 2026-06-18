public class Problem_206 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = reverseList(head.next);

            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }

    public static void main(String[] args) {

        // Create: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();

        ListNode reversedHead = sol.reverseList(head);

        System.out.print("Reversed List: ");

        while (reversedHead != null) {
            System.out.print(reversedHead.val + " ");
            reversedHead = reversedHead.next;
        }
    }
}