package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
	public static void p(Object object) {
		System.out.println(object);

	}

	public static void frontPrint(Tree root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		frontPrint(root.left);
		frontPrint(root.right);
	}

	public static void midPrint(Tree root) {
		if (root == null)
			return;

		midPrint(root.left);
		System.out.print(root.val + " ");
		midPrint(root.right);
	}

	public static void backPrint(Tree root) {
		if (root == null)
			return;

		backPrint(root.left);
		backPrint(root.right);
		System.out.print(root.val + " ");
	}

	public static void levelPrint(Tree root) {
		if (root == null)
			return;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				Tree temNode = queue.poll();
				System.out.print(temNode.val + "  ");
				if (temNode.left != null)
					queue.add(temNode.left);
				if (temNode.right != null)
					queue.add(temNode.right);
			}
			System.out.println();
		}
	}

	public static ArrayList<ArrayList<Integer>> levelPrint2(Tree root) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return list;
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			while (size-- > 0) {
				Tree temNode = queue.poll();
				System.out.print(temNode.val + "  ");
				list2.add(temNode.val);
				if (temNode.left != null)
					queue.add(temNode.left);
				if (temNode.right != null)
					queue.add(temNode.right);
			}
			list.add(list2);
			System.out.println();
		}
		return list;
	}
}
