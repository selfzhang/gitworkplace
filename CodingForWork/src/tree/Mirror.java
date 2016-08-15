package tree;

public class Mirror {

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
		
		PrintTree.levelPrint(root);
		System.out.println();
		mirror(root);
		PrintTree.levelPrint(root);
		
	}

	public static void mirror(Tree A) {
		if (A == null)
			return;
		Tree tempNode = A.left;
		A.left = A.right;
		A.right = tempNode;
		if (A.left != null)
			mirror(A.left);
		if (A.right != null)
			mirror(A.right);
	}
}
