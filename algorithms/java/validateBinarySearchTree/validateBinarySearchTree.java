// Source : https://oj.leetcode.com/problems/validate-binary-search-tree/
// Inspired by : http://www.jiuzhang.com/solutions/validate-binary-search-tree/
// Author : Lei Cao
// Date   : 2015-10-06

/**********************************************************************************
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * OJ's Binary Tree Serialization:
 *
 * The serialization of a binary tree follows a level order traversal, where '#' signifies
 * a path terminator where no node exists below.
 *
 * Here's an example:
 *
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 *
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 **********************************************************************************/

package validateBinarySearchTree;

import common.TreeNode;

import java.util.Stack;

public class validateBinarySearchTree {
    // Solution 1: Traversal
    // The inorder sequence of a BST is a sorted ascending list
    private int lastValue = 0; // the init value of it doesn't matter.
    private boolean firstNode = true;

    public boolean isValidBST(TreeNode root) {
        return isBSTTraversal(root) && isBSTDivideAndConquer(root);
    }

    public boolean isBSTTraversal(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        // firstNode is needed because of if firstNode is Integer.MIN_VALUE,
        // even if we set lastValue to Integer.MIN_VALUE, it will still return false
        if (!firstNode && lastValue >= root.val) {
            return false;
        }

        firstNode = false;
        lastValue = root.val;

        return isValidBST(root.right);

    }

    public boolean isBSTDivideAndConquer(TreeNode root) {
        return isBSTHelper(root).isBST;
    }

    public Result isBSTHelper(TreeNode root) {
        // For leaf node's left or right
        if (root == null) {
            // we set min to Integer.MAX_VALUE and max to Integer.MIN_VALUE
            // because of in the previous level which is the leaf level,
            // we want to set the min or max to that leaf node's val (in the last return line)
            return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        Result left = isBSTHelper(root.left);
        Result right = isBSTHelper(root.right);

        if (!left.isBST || !right.isBST) {
            return new Result(0, 0, false);
        }

        // For non-leaf node
        if (root.left != null && left.max >= root.val
                && root.right != null && right.min <= root.val) {
            return new Result(0, 0, false);
        }

        return new Result(Math.min(left.min, root.val),
                Math.max(right.max, root.val), true);
    }

    // Solution 2: divide && conquer
    private class Result {
        int min;
        int max;
        boolean isBST;

        Result(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    //solution 3 recursive
    public boolean isValidBSTRec(TreeNode root) {
        return isValidBSTRec(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRec(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBSTRec(root.left, minVal, root.val) && isValidBSTRec(root.right, root.val, maxVal);
    }

    //solution 4 - inorder iteration
    public boolean isValidBSTIter (TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode> ();
        TreeNode cur = root ;
        TreeNode pre = null ;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left ;
            } else {
                TreeNode p = stack.pop() ;
                if (pre != null && p.val <= pre.val) {
                    return false ;
                }
                pre = p ;
                cur = p.right ;
            }
        }
        return true ;
    }

}
