package tree;

public class isSymmetrical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean IsSymmetrical(Tree root){
		return IsSymmetrical(root,root);
	}
	public boolean IsSymmetrical(Tree root1, Tree root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return IsSymmetrical(root1.left, root2.right) && IsSymmetrical(root1.right, root2.left);
	}

}
