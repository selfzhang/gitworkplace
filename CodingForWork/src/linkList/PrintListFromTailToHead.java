package linkList;

import java.util.ArrayList;
import java.util.Stack;


public class PrintListFromTailToHead {
	public static ArrayList<Integer> printListFromTailToHead(LinkNode listNode) {
		Stack<LinkNode> stack = new Stack<>();
		while (listNode != null) {
			stack.push(listNode);
			listNode = listNode.next;
		}
		ArrayList<Integer> list = new ArrayList<>();
		while (!stack.empty()) {
			list.add(stack.pop().val);
		}
		return list;

	}

	public static ArrayList<Integer> printListFromTailToHead2(LinkNode listNode, ArrayList<Integer> arrayList) {
		if (listNode.next != null) {
			printListFromTailToHead2(listNode.next, arrayList);
		}
		arrayList.add(listNode.val);
		return arrayList;
	}

	public static ArrayList<Integer> printListFromTailToHead3(LinkNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (listNode != null) {
			printListFromTailToHead2(listNode, arrayList);
		}

		return arrayList;
	}

	public static void main(String[] args) {
		LinkNode listNode1 = new LinkNode(1);
		LinkNode listNode2 = new LinkNode(2);
		LinkNode listNode3 = new LinkNode(3);
		LinkNode listNode4 = new LinkNode(4);
		LinkNode listNode5 = new LinkNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;

		PrintLinkList.p(printListFromTailToHead(listNode1));
		ArrayList<Integer> list = new ArrayList<>();
		//
		PrintLinkList.p(printListFromTailToHead2(listNode1, list));

		PrintLinkList.p(printListFromTailToHead3(listNode1));
		PrintLinkList.printLinkNode(listNode1);
		
	}

}
