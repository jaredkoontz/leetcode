package summaryRanges;

// Source : https://leetcode.com/problems/summary-ranges/
// Author : Hao Chen & Jared Koontz
// Date   : 2014-09-20 / 10-23-2015

import java.util.ArrayList;
import java.util.List;

/**********************************************************************************
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p/>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p/>
 * Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 **********************************************************************************/
public class SummaryRanges {

    public static void main(String[] a) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.run();
    }

    private void run() {
        int[] input = new int[]{1, 2, 3, 5, 8, 12, 13, 14, 15};
        List<String> condensed = condense(input);
        System.out.println(condensed);
        input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 14, 15};
        condensed = condense(input);
        System.out.println(condensed);
    }

    private List<String> condense(int[] input) {
        List<String> list = new ArrayList<>();
        if (input.length == 1) {
            list.add(input[0] + "");
            return list;
        }
        for (int i = 0; i < input.length; i++) {
            int a = input[i];
            while (i + 1 < input.length && (input[i + 1] - input[i]) == 1) {
                i++;
            }
            if (a != input[i]) {
                list.add(a + "->" + input[i]);
            } else {
                list.add(a + "");
            }
        }
        return list;
    }
}
