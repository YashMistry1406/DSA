LeetCode 61 — Rotate List
Problem

Rotate a singly linked list to the right by k places.

Input:   1 → 2 → 3 → 4 → 5,  k = 2
Output:  4 → 5 → 1 → 2 → 3

Connection With My Array Rotation Logic

For an array, I can think of right rotation as splitting the array:

1  2  3 | 4  5
         ↓
4  5 | 1  2  3


The main idea is:

Move the last k elements to the front.

In my array solution, I achieve this using reverse operations:

1  2  3  4  5
↓ reverse all
5  4  3  2  1
↓ reverse first k
4  5  3  2  1
↓ reverse remaining
4  5  1  2  3


For a linked list, I use the same rotation concept, but instead of indexes/reversing elements, I change the next pointers.

Linked List Algorithm

Given:

1 → 2 → 3 → 4 → 5 → null
k = 2

Step 1 — Find the length and tail

Traverse the list.

1 → 2 → 3 → 4 → 5 → null
                    ↑
                   tail


For this example:

n = 5
tail = 5

Step 2 — Reduce k

A rotation by n positions brings the list back to its original form.

k = k % n;


Example:

k = 12
n = 5

12 % 5 = 2


So only 2 rotations are required.

If k == 0, return the original list.

Step 3 — Make the list circular

Connect the tail to the head:

tail.next = head;


Before:

1 → 2 → 3 → 4 → 5 → null


After:

1 → 2 → 3 → 4 → 5
↑                   ↓
└───────────────────┘

Step 4 — Find the new tail

For a right rotation:

newTail position = n - k - 1


Here:

n = 5
k = 2

5 - 2 - 1 = 2


Index 2 is node 3.

So:

1 → 2 → 3 → 4 → 5
        ↑
     newTail

Step 5 — Find the new head

The node immediately after newTail becomes the new head.

newHead = newTail.next;


Therefore:

newHead = 4

Step 6 — Break the circle
newTail.next = null;


Final result:

4 → 5 → 1 → 2 → 3 → null

Code
public ListNode rotateRight(ListNode head, int k) {

    // Edge cases
    if (head == null || head.next == null || k == 0) {
        return head;
    }

    // Find length and tail
    int n = 1;
    ListNode tail = head;

    while (tail.next != null) {
        tail = tail.next;
        n++;
    }

    // Remove unnecessary rotations
    k = k % n;

    if (k == 0) {
        return head;
    }

    // Make the list circular
    tail.next = head;

    // Find the new tail
    int steps = n - k - 1;
    ListNode newTail = head;

    for (int i = 0; i < steps; i++) {
        newTail = newTail.next;
    }

    // Node after newTail becomes the new head
    ListNode newHead = newTail.next;

    // Break the circular list
    newTail.next = null;

    return newHead;
}

Dry Run
List:
1 → 2 → 3 → 4 → 5

k = 2
n = 5


Find new tail:

n - k - 1
= 5 - 2 - 1
= 2


So:

1 → 2 → 3 → 4 → 5
        ↑     ↑
    newTail  newHead


Make circular:

1 → 2 → 3 → 4 → 5
↑                   ↓
└───────────────────┘


Then:

newHead = newTail.next;


gives:

newHead = 4


Finally:

newTail.next = null;


Result:

4 → 5 → 1 → 2 → 3 → null

Important Pattern
RIGHT ROTATION BY K

1. Find length n and tail
2. k = k % n
3. Make tail.next = head
4. Find newTail at n-k-1
5. newHead = newTail.next
6. newTail.next = null
7. Return newHead

Array vs Linked List
Array	Linked List
Uses indexes	Uses nodes/pointers
arr[i]	node.next
Can reverse elements	Change connections
Move last k elements	Move last k nodes
O(n) with reverse method	O(n)
O(1) extra space	O(1) extra space
Complexity
Time  : O(n)
Space : O(1)

Core Idea

Don't focus on "rotation" itself.

Think:

1 → 2 → 3 | 4 → 5
            ↓
4 → 5 | 1 → 2 → 3


The problem is simply:

Find where to cut the linked list, move that portion to the front, and reconnect the pointers.
