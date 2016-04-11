package palindromeLinkedList;

import common.ListNode;

//todo
public class palindromeLinkedList {


	public ListNode root;

	public boolean isPalindrome(ListNode head) {
		root = head;
		return (head == null) || isPalindromeHelper(head);
	}

	public boolean isPalindromeHelper(ListNode head) {
		boolean flag = true;
		if (head.next != null) {
			flag = isPalindromeHelper(head.next);
		}
		if (flag && root.val == head.val) {
			root = root.next;
			return true;
		}
		return false;
	}
}
