package sumRootToLeafNumber;

import common.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by jared koontz on 10/23/15.
 */
public class SumRootToLeafNumberTest {

	@Test
	public void testSum() {
		ArrayList<TreeNode> inputs = new ArrayList<>();
		boolean[] results = {false, false};
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);

		n0.left = n1;
		n1.left = n2;
		n2.left = n3;

		TreeNode nn0 = new TreeNode(0);
		TreeNode nn1 = new TreeNode(1);
		TreeNode nn2 = new TreeNode(2);
		TreeNode nn3 = new TreeNode(3);
		nn0.right = nn1;
		nn1.left = nn2;
		nn2.left = nn3;

		SumRootToLeafNumber sr = new SumRootToLeafNumber();
		System.out.println(sr.sumNumbers(n0));
		System.out.println(sr.sumNumbers(nn0));

	}

}
