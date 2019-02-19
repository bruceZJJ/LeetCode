/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * */

package No2.两数相加;
/*
 * @author zhanjj
 * @date 2018/12/1 22:32
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 存储结果的链表 0是头节点 返回结果时返回l3.next
        ListNode l3 = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = l3;
        // sum用来临时存储l1和l2每个节点相加的结果
        int sum = 0;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            // 由于每个节点只能存储一位数，所以取模后存入l3中的下一个新节点
            p3.next = new ListNode(sum % 10);
            // 进位，计算下一l1和l2节点相加之前 sum为1；不进位 sum为0
            sum /= 10;
            p3 = p3.next;
        }
        if (sum == 1) {
            // 进位
            p3.next = new ListNode(1);
        }
        return l3.next;
    }
}
