package solutions;

/**
 * >>add two number>>
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 *
 */

public class _0002 {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		/**
		 * call this method like list.add(node).add(node) adn so on..
		 */
		ListNode add(ListNode node) {
			ListNode aux = next;
			if (next == null) {
				next = node;
			} else {
				next = next.next;
				add(node);
				next = aux;
			}
			return node;
		}

		void display() {
			ListNode list = this;

			do {
				System.out.print(list.val + ((list.next == null) ? "\n" : " -> "));
				list = list.next;
			} while (list != null);
		}
	}

	static class Solution {
		//my own solution.
		static ListNode bruteForce(ListNode l1, ListNode l2) {

			ListNode result = null; // List's head
			ListNode aux = null;
			boolean carry = false;

			do {
				int n0 = (l1 == null) ? 0 : l1.val;
				int n1 = (l2 == null) ? 0 : l2.val;
				int sum = n0 + n1 + ((carry) ? 1 : 0);
				carry = (sum > 9) ? true : false;

				if (result == null)
					aux = result = new ListNode(sum % 10);
				else
					aux = aux.next = new ListNode(sum % 10); // sum%10 wraps the number in case sum exceeds 9.

				l1 = (l1 != null) ? l1.next : l1; // gettin' next node
				l2 = (l2 != null) ? l2.next : l2;

			} while (l1 != null || l2 != null || carry);

			return result;
		}

		//Given answer.
		static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			ListNode dummyHead = new ListNode(0);
			ListNode p = l1, q = l2, curr = dummyHead;
			int carry = 0;
			while (p != null || q != null) {
				int x = (p != null) ? p.val : 0;
				int y = (q != null) ? q.val : 0;
				int sum = carry + x + y;
				carry = sum / 10;
				curr.next = new ListNode(sum % 10);
				curr = curr.next;
				if (p != null)
					p = p.next;
				if (q != null)
					q = q.next;
			}
			if (carry > 0) {
				curr.next = new ListNode(carry);
			}
			return dummyHead.next;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(5);

		n1.add(new ListNode(4)).add(new ListNode(3));
		n2.add(new ListNode(6)).add(new ListNode(4));

		Solution.bruteForce(n1, n2).display();
	}
}
//23-dec-2019 16:16
