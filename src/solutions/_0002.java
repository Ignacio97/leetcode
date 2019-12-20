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
	}

	static class Solution {

		static ListNode bruteForce(ListNode l1, ListNode l2) {
			return l2;
		}

		static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(5);
		
		n1.add(new ListNode(4)).add(new ListNode(3));
		n2.add(new ListNode(6)).add(new ListNode(4));
		

		
	}
}
