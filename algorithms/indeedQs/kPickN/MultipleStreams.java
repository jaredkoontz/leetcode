package kPickN;

import java.util.ArrayList;

/**
 * Created by Jared on 11/7/2015.
 */
public class MultipleStreams {

    public static void main(String[] a) {
        MultipleStreams s = new MultipleStreams();
        s.runTests();
    }

    private void runTests() {
        ArrayList<PeekingIterator> iterators = TestCases.getIterator(1);
        int n = 2;
        KPickN.kPickN(n, iterators);
    }

}
