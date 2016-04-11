package binaryTreeLevelOrderTraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//todo
public class binaryTreeLevelOrderTraversalII {
    /*DFS solution:*/


	public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if (root == null) return wrapList;

		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelNum = queue.size();
			List<Integer> subList = new LinkedList<Integer>();
			for (int i = 0; i < levelNum; i++) {
				if (queue.peek().left != null) queue.offer(queue.peek().left);
				if (queue.peek().right != null) queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(0, subList);
		}
		return wrapList;
	}

    /*BFS solution:*/


	public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
		levelMaker(wrapList, root, 0);
		return wrapList;
	}

	public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
		if (root == null) return;
		if (level >= list.size()) {
			list.add(0, new LinkedList<Integer>());
		}
		levelMaker(list, root.left, level + 1);
		levelMaker(list, root.right, level + 1);
		list.get(list.size() - level - 1).add(root.val);
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> container = new ArrayList<List<Integer>>();
		if (root == null) return container;
		TreeNode cur = null;
		Queue<TreeNode> sameLevel = new LinkedList<TreeNode>();
		sameLevel.add(root);
		while (!sameLevel.isEmpty()) {
			List<Integer> oneLevel = new ArrayList<Integer>();
			Queue<TreeNode> temp = new LinkedList<TreeNode>();
			while (!sameLevel.isEmpty()) {
				cur = sameLevel.remove();
				oneLevel.add(cur.val);
				if (cur.left != null) temp.add(cur.left);
				if (cur.right != null) temp.add(cur.right);
			}
			container.add(0, oneLevel);
			sameLevel = temp;
		}
		return container;
	}
}

