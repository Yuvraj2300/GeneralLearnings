package pakcage2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static void main(String[] args) {
		Solution sol	=	new	 Solution();
		sol.levelOrder(new TreeNode(89));
	}
}

class Solution {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> l = new ArrayList<>(size);

			for (int i = 0; i < size; i++) {
				TreeNode n = queue.remove();
				l.add(n.val);

				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}

			result.add(l);
		}

		return result;
	}
}
