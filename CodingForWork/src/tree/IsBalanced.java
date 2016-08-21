package tree;

public class IsBalanced {
	private boolean isBalance = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean IsBalanced_Solution(Tree root) {

		getDepth(root);
		return isBalance;
	}

	public int getDepth(Tree root) {
		if (root == null) {

			return 0;
		}
		int left = getDepth(root.left) + 1;
		int right = getDepth(root.right) + 1;

		if (Math.abs(left - right) > 1) {
			isBalance = false;

		}
		if (left > right)
			return left;
		else
			return right;
	}
}
