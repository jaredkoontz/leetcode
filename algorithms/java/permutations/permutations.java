package permutations;

import java.util.ArrayList;
import java.util.List;

//todo
/*
Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
public class permutations {
	private List<List<Integer>> res;

	private void permuteHelper(int num[], int idx) {
		if (idx == num.length) {
			res.add(getOne(num));
			return;
		}
		for (int j = idx; j < num.length; j++) {
			//Arrays.sort(num, idx, num.length);
			swap(num, idx, j);
			permuteHelper(num, idx + 1);
			swap(num, idx, j);
		}
	}

	private void swap(int num[], int i, int j) {
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}

	private List<Integer> getOne(int num[]) {
		List<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) tmp.add(num[i]);
		return tmp;
	}

	public List<List<Integer>> permute(int[] num) {
		res = new ArrayList<List<Integer>>();
		permuteHelper(num, 0);
		return res;
	}
}
