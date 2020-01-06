package Problem;

public class Add2Numbers {

	public static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {

	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode fake = new ListNode(-1);
		ListNode temp = fake;

		int carry = 0;

		while (l1 != null || l2 != null) {

			int val1 = l1 != null ? l1.val : 0;
			int val2 = l2 != null ? l2.val : 0;

			int sum = carry + val1 + val2;

			carry = sum / 10;
			sum = sum % 10;

			ListNode sumNode = new ListNode(sum);
			temp.next = sumNode;
			temp = temp.next;

			if (l1 != null) {
				l1 = l1.next;
			}

			if (l2 != null) {
				l2 = l2.next;
			}
		}

		if (carry > 0) {
			ListNode carryNode = new ListNode(carry);
			temp.next = carryNode;
		}

		return fake.next;
	}
}
