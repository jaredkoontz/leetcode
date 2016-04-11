package binaryTreeInorderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//todo
public class binaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// method 1: recursion

		helper(root, res);
		return res;
	}

	//helper function for method 1
	private void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			if (root.left != null) {
				helper(root.left, res);
			}
			res.add(root.val);
			if (root.right != null) {
				helper(root.right, res);
			}
		}
	}

	public List<Integer> inorderTraversalIter(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		// method 2: iteration
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}

	public List<Integer> inorderTraversalSmart(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;

		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;
	}
}
