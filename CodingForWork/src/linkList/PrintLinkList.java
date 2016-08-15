package linkList;

public class PrintLinkList {
	public static void p(Object object) {
		System.out.println(object);

	}

	public static void printLinkNode(LinkNode head) {
		while (head != null) {
			System.out.print(head.val+" ->");
			head=head.next;
		}
		System.out.println("null");
	}
}
