package tree;

import java.util.LinkedList;
import java.util.Queue;



public class MaxDepth {

	public static int maxDepth(Tree node) {
		if (node == null) {
			return 0;
		}
		int leftDepth = maxDepth(node.left) + 1;
		int rightDepth = maxDepth(node.right) + 1;

		if (rightDepth > leftDepth) {

			return rightDepth;
		} else {

			return leftDepth;
		}
	}

	public static int maxDepth2(Tree root) {
		int depth = 0;
		if (root == null) {
			return 0;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			if(size>0){
				depth++;
			}
			while (size-- > 0) {
				Tree node = queue.poll();
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			
		}
		return depth;
	}

	public static void main(String[] args) {
		Tree root = new Tree(0);
		Tree node1 = new Tree(1);
		Tree node2 = new Tree(2);
		Tree node3 = new Tree(3);
		Tree node4 = new Tree(4);
		Tree node5 = new Tree(5);
		Tree node6 = new Tree(6);
		Tree node7 = new Tree(7);
		Tree node8 = new Tree(8);
		Tree node9 = new Tree(9);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node3.left = node4;
		node2.left = node5;
		node2.right = node6;
		node3.right = node7;
		node7.left = node8;
		node6.right = node9;
		System.out.println(maxDepth2(root));
		System.out.println(maxDepth(root));
	}

}
