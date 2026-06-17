// 237. Delete Node in a Linked List

public class Problem_237 {


    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val) {
            this.val= val;
        }

        
        ListNode(int val, ListNode next) {
            this.val= val;
            this.next= next;
        }

        
    }
    static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

    static void printList(ListNode head){
        while(head!= null){
            System.out.print(head.val);
            head= head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head= new ListNode(4);

        head.next= new ListNode(5);
        head.next.next= new ListNode(1);
        head.next.next.next= new ListNode(9);
        System.out.println("Before deletion:");

        printList(head);

        deleteNode(head.next);

        System.out.println("After deletion:");

        printList(head);
    }
}
