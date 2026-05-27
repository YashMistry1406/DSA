
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class FindIntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        int len_1 = 1;
        while (tempA.next != null) {
            len_1 += 1;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        int len_2 = 1;
        while (tempB.next != null) {
            len_2 += 1;
            tempB = tempB.next;
        }
        int diff = (len_1 > len_2) ? len_1 - len_2 : len_2 - len_1;
        System.out.print(diff);

        tempA = headA;
        tempB = headB;
        if (len_1 > len_2) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
