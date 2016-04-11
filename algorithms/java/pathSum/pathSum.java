package pathSum;

import common.TreeNode;

//todo
public class pathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;

		if (root.left == null && root.right == null && sum - root.val == 0) return true;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}


	public boolean hasPathSumOptimized(TreeNode root, int sum) {
		if (root == null) return false;

		if (root.left == null && root.right == null) return sum == root.val;

		return hasPathSumOptimized(root.left, sum - root.val) || hasPathSumOptimized(root.right, sum - root.val);
	}
}
