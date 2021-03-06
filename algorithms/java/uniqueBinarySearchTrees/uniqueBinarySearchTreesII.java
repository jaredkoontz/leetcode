package uniqueBinarySearchTrees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//todo
public class uniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees2(int n) {
		List<TreeNode>[] result = new List[n + 1];
		result[0] = new ArrayList<TreeNode>();
		result[0].add(null);

		for (int len = 1; len <= n; len++) {
			result[len] = new ArrayList<TreeNode>();
			for (int j = 0; j < len; j++) {
				for (TreeNode nodeL : result[j]) {
					for (TreeNode nodeR : result[len - j - 1]) {
						TreeNode node = new TreeNode(j + 1);
						node.left = nodeL;
						node.right = clone(nodeR, j + 1);
						result[len].add(node);
					}
				}
			}
		}
		return result[n];
	}

	private static TreeNode clone(TreeNode n, int offset) {
		if (n == null)
			return null;
		TreeNode node = new TreeNode(n.val + offset);
		node.left = clone(n.left, offset);
		node.right = clone(n.right, offset);
		return node;
	}

	public List<TreeNode> generateTrees(int n) {

		return genTrees(1, n);
	}

	public List<TreeNode> genTrees(int start, int end) {

		List<TreeNode> list = new ArrayList<TreeNode>();

		if (start > end) {
			list.add(null);
			return list;
		}

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {

			left = genTrees(start, i - 1);
			right = genTrees(i + 1, end);

			for (TreeNode lnode : left) {
				for (TreeNode rnode : right) {
					TreeNode root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
				}
			}

		}

		return list;
	}
}
