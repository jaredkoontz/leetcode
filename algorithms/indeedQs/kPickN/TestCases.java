package kPickN;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Jared on 11/7/2015.
 */
public class TestCases {
    public static ArrayList<PeekingIterator> testCase1() {
        ArrayList<PeekingIterator> iters = new ArrayList<>();

        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] array2 = new Integer[]{3, 4, 5, 6, 7, 8, 9};
        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5};

        PeekingIterator list1 = new PeekingIterator(Arrays.asList(array1).iterator());
        PeekingIterator list2 = new PeekingIterator(Arrays.asList(array2).iterator());
        PeekingIterator list3 = new PeekingIterator(Arrays.asList(array3).iterator());

        iters.add(list1);
        iters.add(list2);
        iters.add(list3);
        return iters;
    }

    public static ArrayList<PeekingIterator> testCase2() {
        ArrayList<PeekingIterator> iters = new ArrayList<>();

        Integer[] array1 = new Integer[]{1, 2*1000, 3*1000, 4*1000};
        Integer[] array2 = new Integer[]{3*1000, 4*1000};
        Integer[] array3 = new Integer[]{1, 2, 3, 4*1000};

        PeekingIterator list1 = new PeekingIterator(Arrays.asList(array1).iterator());
        PeekingIterator list2 = new PeekingIterator(Arrays.asList(array2).iterator());
        PeekingIterator list3 = new PeekingIterator(Arrays.asList(array3).iterator());

        iters.add(list1);
        iters.add(list2);
        iters.add(list3);
        return iters;
    }

    public static ArrayList<PeekingIterator> testCase3() {
        ArrayList<PeekingIterator> iters = new ArrayList<>();

        Integer[] array1 = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] array2 = new Integer[]{3, 4, 5, 6, 7, 8, 9};
        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5};

        PeekingIterator list1 = new PeekingIterator(Arrays.asList(array1).iterator());
        PeekingIterator list2 = new PeekingIterator(Arrays.asList(array2).iterator());
        PeekingIterator list3 = new PeekingIterator(Arrays.asList(array3).iterator());

        iters.add(list1);
        iters.add(list2);
        iters.add(list3);
        return iters;
    }

    public static ArrayList<PeekingIterator> getIterator(int i) {

            switch (i){
                case 1:
                    return TestCases.testCase1();
                case 2:
                    return TestCases.testCase1();
                case 3:
                    return TestCases.testCase3();
                default:
                    return TestCases.testCase1();
            }
        }
}
