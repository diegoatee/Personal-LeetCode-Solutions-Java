/*
Idea:
First, check if either, or both lists are null. If that is the case, simply return null, the head of list1, or the head of list2.

Next, iterate over both lists while their pointers are not yet at the end of their respective lists. Depending on which of the 2 values is smaller, then add it to the result list.

Once either list has no values left, then iterate over the remaining list, adding its values to the result list.

Time complexity: O(N)
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return list1;
        }
        else if (list1 == null) {
            return list2;
        }
        else if (list2 == null) {
            return list1;
        }

        ListNode head = null;
        ListNode cur = null;
        boolean list1Finished = false;
        boolean list2Finished = false;

        if (list1.val < list2.val) {
            head = list1;
            if (list1.next != null) {
                list1 = list1.next;
            }
            else {
                list1Finished = true;
            }
        }
        else {
            head = list2;
            if (list2.next != null) {
                list2 = list2.next;
            }
            else {
                list2Finished = true;
            }
        }

        cur = head;

        while (!list1Finished && !list2Finished) {
            if (list1.val < list2.val) {
                cur.next = list1;
                cur = cur.next;
                if (list1.next != null) {
                    list1 = list1.next;
                }
                else {
                    list1Finished = true;
                    break;
                }
            }
            else {
                cur.next = list2;
                cur = cur.next;
                if (list2.next != null) {
                    list2 = list2.next;
                }
                else {
                    list2Finished = true;
                    break;
                }
            }
        }

        if (!list1Finished) {
            while (list1 != null) {
                cur.next = list1;
                cur = cur.next;
                if (list1.next != null) {
                    list1 = list1.next;
                }
                else {
                    break;
                }

            }
        }
        if (!list2Finished) {
            while (list2 != null) {
                cur.next = list2;
                cur = cur.next;
                if (list2.next != null) {
                    list2 = list2.next;
                }
                else {
                    break;
                }

            }
        }

        return head;
    }
}
