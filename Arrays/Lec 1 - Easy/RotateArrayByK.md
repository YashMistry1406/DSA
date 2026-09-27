Array Rotation — Complete Notes
Problem

Given an array, rotate its elements either left or right by k positions.

Example:

Original:
[1, 2, 3, 4, 5]

Right rotation by 2:
[4, 5, 1, 2, 3]

Left rotation by 2:
[3, 4, 5, 1, 2]

1. Left Rotation by One Position
Idea

For a left rotation:

[1, 2, 3, 4, 5]
 ↓
[2, 3, 4, 5, 1]


The first element moves to the end.

Algorithm

Store the first element in temp.

Shift every element one position to the left.

Put temp at the last position.

Return the array.

Code
static int[] rotateArrayLeft(int[] arr, int n)
{
    int temp = arr[0];

    for (int i = 0; i < n - 1; i++)
    {
        arr[i] = arr[i + 1];
    }

    arr[n - 1] = temp;

    return arr;
}

Dry Run
[1, 2, 3, 4, 5]

temp = 1

Shift:
[2, 3, 4, 5, 5]

Put temp at end:
[2, 3, 4, 5, 1]

Complexity
Time  : O(n)
Space : O(1)

2. Left Rotation K Times

Instead of rotating once, repeat the same operation k times.

Code
static int[] rotateArrayLeftKTimes(int[] arr, int n, int k)
{
    while (k > 0)
    {
        int temp = arr[0];

        for (int i = 0; i < n - 1; i++)
        {
            arr[i] = arr[i + 1];
        }

        arr[n - 1] = temp;

        k--;
    }

    return arr;
}

Example
Array = [1, 2, 3, 4, 5]
k = 2


First rotation:

[2, 3, 4, 5, 1]


Second rotation:

[3, 4, 5, 1, 2]

Complexity

One rotation:

O(n)


k rotations:

O(n × k)


Space:

O(1)

3. Right Rotation by One Position

For a right rotation:

[1, 2, 3, 4, 5]
 ↓
[5, 1, 2, 3, 4]


The last element moves to the beginning.

Algorithm

Store the last element in temp.

Shift every element one position to the right.

Put temp at index 0.

Return the array.

Code
static int[] rotateArrayRight(int[] arr, int n)
{
    int temp = arr[n - 1];

    for (int i = n - 1; i > 0; i--)
    {
        arr[i] = arr[i - 1];
    }

    arr[0] = temp;

    return arr;
}

Dry Run
[1, 2, 3, 4, 5]

temp = 5

Shift from right to left:

[1, 1, 2, 3, 4]

Put temp at index 0:

[5, 1, 2, 3, 4]

Why do we shift from right to left?

Because if we shifted from left to right, we would overwrite values that we still need.

Correct:

for (int i = n - 1; i > 0; i--)


We start at the end and move backwards.

4. Right Rotation K Times
Code
static int[] rotateArrayRightKtimes(int[] arr, int n, int k)
{
    while (k > 0)
    {
        int temp = arr[n - 1];

        for (int i = n - 1; i > 0; i--)
        {
            arr[i] = arr[i - 1];
        }

        arr[0] = temp;

        k--;
    }

    return arr;
}

Example
[1, 2, 3, 4, 5]
k = 2


First rotation:

[5, 1, 2, 3, 4]


Second rotation:

[4, 5, 1, 2, 3]

Complexity
Time  : O(n × k)
Space : O(1)


This works, but it is inefficient when k is large.

5. Optimized Rotation Using Reverse

This is the most important approach in your code.

Instead of rotating one position at a time, we can rotate the array in O(n) using reversing.

Your helper method is:

void reverseArray(int[] nums, int start, int end)
{
    while (start < end)
    {
        int temp = nums[start];

        nums[start] = nums[end];
        nums[end] = temp;

        start++;
        end--;
    }
}

6. How reverseArray() Works

Suppose:

[1, 2, 3, 4, 5]


Call:

reverseArray(nums, 0, 4);


The algorithm uses two pointers:

start → 1  2  3  4  5 ← end


Swap:

5  2  3  4  1


Move pointers:

   start → 2  3  4 ← end


Swap:

5  4  3  2  1


Final:

[5, 4, 3, 2, 1]

Reverse Algorithm
while start < end:

    swap nums[start] and nums[end]

    start++
    end--

Complexity
Time  : O(n)
Space : O(1)

7. Right Rotation Using Reverse

Your code:

if (direction.equals("right"))
{
    reverseArray(nums, 0, n - 1);

    reverseArray(nums, 0, k - 1);

    reverseArray(nums, k, n - 1);
}


This is based on a very useful pattern.

Suppose:

Array = [1, 2, 3, 4, 5]
k = 2


Separate the array conceptually:

[1, 2, 3] [4, 5]
   n-k       k


We want:

[4, 5] [1, 2, 3]

Step 1 — Reverse the entire array
[1, 2, 3, 4, 5]

        ↓

[5, 4, 3, 2, 1]

Step 2 — Reverse the first k elements
[5, 4 | 3, 2, 1]

        ↓

[4, 5 | 3, 2, 1]

Step 3 — Reverse the remaining elements
[4, 5 | 3, 2, 1]

        ↓

[4, 5 | 1, 2, 3]


Final:

[4, 5, 1, 2, 3]

8. Right Rotation Formula

For right rotation:

Step 1:
reverse(0, n-1)

Step 2:
reverse(0, k-1)

Step 3:
reverse(k, n-1)


In code:

reverseArray(nums, 0, n - 1);
reverseArray(nums, 0, k - 1);
reverseArray(nums, k, n - 1);


Remember:

RIGHT ROTATION

Reverse ALL
    ↓
Reverse FIRST k
    ↓
Reverse REST

9. Left Rotation Using Reverse

Your code:

else if (direction.equals("left"))
{
    reverseArray(nums, 0, k - 1);

    reverseArray(nums, k, n - 1);

    reverseArray(nums, 0, n - 1);
}


Example:

[1, 2, 3, 4, 5]
k = 2


We want:

[3, 4, 5, 1, 2]


Think of the array as:

[1, 2] [3, 4, 5]

Step 1 — Reverse first k
[2, 1] [3, 4, 5]

Step 2 — Reverse remaining elements
[2, 1] [5, 4, 3]

Step 3 — Reverse the entire array
[3, 4, 5, 1, 2]


Final answer:

[3, 4, 5, 1, 2]

10. Left Rotation Formula
Step 1:
reverse(0, k-1)

Step 2:
reverse(k, n-1)

Step 3:
reverse(0, n-1)


Remember:

LEFT ROTATION

Reverse FIRST k
    ↓
Reverse REST
    ↓
Reverse ALL

11. Why k % n?

Your code contains:

k = k % n;


This prevents unnecessary rotations.

Suppose:

Array = [1, 2, 3, 4, 5]
n = 5
k = 12


Every 5 rotations brings the array back to the original.

Therefore:

12 % 5 = 2


So:

rotate by 12


is equivalent to:

rotate by 2


This is especially important for the reverse approach.

12. Complete Optimized Method

Your main rotation method can be summarized as:

public int[] rotateArray(int[] nums, int k, String direction)
{
    int n = nums.length;

    if (n == 0 || k == 0)
        return nums;

    k = k % n;

    if (direction.equals("right"))
    {
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }
    else if (direction.equals("left"))
    {
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        reverseArray(nums, 0, n - 1);
    }

    return nums;
}

13. Complete Thought Process

When you see:

Rotate array by k


think:

1. What direction?
       ↓
   LEFT / RIGHT

2. Is k bigger than n?
       ↓
   k = k % n

3. Can I do it with reverse?
       ↓
   YES

4. RIGHT?
       ↓
   Reverse ALL
   Reverse FIRST k
   Reverse REST

5. LEFT?
       ↓
   Reverse FIRST k
   Reverse REST
   Reverse ALL

14. Complexity Comparison
Approach	Time	Space
Left/Right by 1	O(n)	O(1)
Rotate k times	O(n × k)	O(1)
Reverse method	O(n)	O(1)

The reverse method is preferred when the problem requires efficient rotation.

15. Important Connection to Linked Lists

The same fundamental idea appears in LeetCode 61 — Rotate List.

For an array:

[1, 2, 3] [4, 5]
            ↓
[4, 5] [1, 2, 3]


For a linked list:

1 → 2 → 3 → 4 → 5
            ↓
4 → 5 → 1 → 2 → 3


The concept is the same:

Move the last k elements/nodes to the front.

The difference is the data structure.

ARRAY
→ indexes
→ reverse elements

LINKED LIST
→ nodes
→ next pointers
→ change connections

Quick Revision
Left by 1
Store first
Shift left
Put first at end

Right by 1
Store last
Shift right
Put last at beginning

Right by K — Reverse
Reverse ALL
Reverse FIRST k
Reverse REST

Left by K — Reverse
Reverse FIRST k
Reverse REST
Reverse ALL

Always remember
k = k % n;

Complexity of optimized solution
Time  : O(n)
Space : O(1)

Core mental model
RIGHT:

A B C | D E
       ↓
D E | A B C


LEFT:

A B | C D E
      ↓
C D E | A B


Rotation is fundamentally about moving one section of the array from one side to the other. The reverse technique is simply a clever way of doing that in-place.
