package linkList;

public class Merge {

	public static void main(String[] args) {

		LinkNode listNode1 = new LinkNode(1);
		LinkNode listNode2 = new LinkNode(2);
		LinkNode listNode3 = new LinkNode(3);
		LinkNode listNode4 = new LinkNode(4);
		LinkNode listNode5 = new LinkNode(10);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		LinkNode listNode6 = new LinkNode(1);
		LinkNode listNode7 = new LinkNode(2);
		LinkNode listNode8 = new LinkNode(5);
		LinkNode listNode9 = new LinkNode(8);

		listNode6.next = listNode7;
		listNode7.next = listNode8;
		listNode8.next = listNode9;

		PrintLinkList.printLinkNode(merge2(listNode1, listNode6));
	}

	public static LinkNode merge(LinkNode root1, LinkNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		LinkNode head = null;
		if (root1.val < root2.val) {
			head = root1;
			head.next = merge(root1.next, root2);
		} else {
			head = root2;
			head.next = merge(root1, root2.next);
		}
		return head;
	}

	public static LinkNode merge2(LinkNode root1, LinkNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		LinkNode head = null;
		if (root1.val < root2.val) {
			head = root1;

			root1 = root1.next;
		} else {
			head = root2;
			root2 = root2.next;
		}
		LinkNode p = head;

		while (root1 != null && root2 != null) {

			if (root1.val < root2.val) {

				p.next = root1;
				p = root1;
				root1 = root1.next;
			} else {
				p.next = root2;
				p = root2;
				root2 = root2.next;
			}
		}
		if (root1 != null) {
			p.next = root1;
		} else {
			p.next = root2;
		}
		return head;
	}
}


