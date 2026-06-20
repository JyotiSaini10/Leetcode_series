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

public class Problem_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head== null || head.next== null){
            return head;
        }

            ListNode even= head.next; 
            ListNode odd= head;
            ListNode evenHead= head.next;
        while(even!= null && even.next!= null){
                odd.next= odd.next.next;
                even.next= even.next.next;

                odd= odd.next;
                even= even.next;

        }
        odd.next= evenHead;
        return head;
    }
public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    Problem_328 sol = new Problem_328();
    ListNode ans = sol.oddEvenList(head);

    while (ans != null) {
        System.out.print(ans.val + " ");
        ans = ans.next;
    }
}
}
