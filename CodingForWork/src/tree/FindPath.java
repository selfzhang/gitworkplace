package tree;

import java.util.ArrayList;

public class FindPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> findPath(Tree root, int target) {
		ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>();

		return findPath(root, target, path, 0);
	}

	public ArrayList<ArrayList<Integer>> findPath(Tree root, int target, ArrayList<ArrayList<Integer>> path,
			int currentCost) {

		return path;
	}
}
