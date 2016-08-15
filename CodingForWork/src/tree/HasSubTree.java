package tree;

public class HasSubTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		Tree root2 = new Tree(0);
		Tree node11 = new Tree(1);
		Tree node21 = new Tree(2);
		root2.left = node11;
		root2.right = node21;
		
		System.out.println(hasSubTree(root,root2));
	}

	public static boolean AhasB(Tree A, Tree B) {
		if (B == null)
			return true;
		if (A == null)
			return false;
		if (A.val != B.val)
			return false;
		return AhasB(A.left, B.left) && AhasB(A.right, B.right);
	}

	public static boolean hasSubTree(Tree A, Tree B) {
		boolean result = false;
		if (A != null && B != null) {
			if (A.val == B.val)
				result = AhasB(A, B);
			if (!result)
				result = hasSubTree(A.left, B);
			if (!result)
				result = hasSubTree(A.right, B);
		}

		return result;
	}
}
