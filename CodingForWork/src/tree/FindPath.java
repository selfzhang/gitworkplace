package tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class FindPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> findPath(Tree root, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (root == null || target == 0) {
			return list;
		}
		Stack<Tree> path = new Stack<Tree>();
		findPath(root, target, path, 0, list);
		return list;
	}

	public void findPath(Tree root, int target, Stack<Tree> path, int currentCost, ArrayList<ArrayList<Integer>> list) {
		currentCost += root.val;
		path.push(root);
		if (root.left == null && root.right == null && currentCost == target) {
			ArrayList<Integer> templist = new ArrayList<Integer>();

			Iterator<Tree> iterator = path.iterator();
			while (iterator.hasNext()) {
				Tree temp = iterator.next();
				templist.add(temp.val);
			}
			list.add(templist);
		}
		if (root.left != null) {
			findPath(root.left, target, path, currentCost, list);

		}
		if (root.right != null) {
			findPath(root.right, target, path, currentCost, list);

		}
		path.pop();
	}
}
