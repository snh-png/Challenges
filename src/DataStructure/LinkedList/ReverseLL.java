package DataStructure.LinkedList;

public class ReverseLL {
//    public ListNode reverseList(ListNode head) {
//        /* iterative solution */
//        ListNode newHead = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = newHead;
//            newHead = head;
//            head = next;
//        }
//        return newHead;
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        ReverseLL reverseLL = new ReverseLL();
        ListNode listNode = reverseLL.reverseList(head);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
