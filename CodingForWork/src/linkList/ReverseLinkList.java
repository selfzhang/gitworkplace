package linkList;

public class ReverseLinkList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkNode listNode1 = new LinkNode(1);
		LinkNode listNode2 = new LinkNode(2);
		LinkNode listNode3 = new LinkNode(5);
		LinkNode listNode4 = new LinkNode(4);
		LinkNode listNode5 = new LinkNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		PrintLinkList.printLinkNode(listNode1);
		PrintLinkList.printLinkNode(reverseLinkList(listNode1));
	}

	public static LinkNode reverseLinkList(LinkNode head) {
		if (head == null) {
			return null;
		}
		LinkNode revHead = null;
		LinkNode pNode = head;
		LinkNode pPrevNode = null;
		while (pNode != null) {
			LinkNode pNext = pNode.next;
			if (pNext == null) {
				revHead = pNode;
			}
			pNode.next = pPrevNode;
			pPrevNode = pNode;
			pNode = pNext;
		}
		return revHead;
	}

}
