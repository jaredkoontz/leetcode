package kPickN;

import java.util.ArrayList;

/**
 * Created by Jared on 11/7/2015.
 */
public class KPickN {
    public static void kPickN(int n, ArrayList<PeekingIterator> iterators) {
        int k = iterators.size();
        runKPickN(iterators,n,k);
    }

    private static void runKPickN(ArrayList<PeekingIterator> iterators, int n, int k) {
        findStartingPoint(iterators);

    }

    private static void findStartingPoint(ArrayList<PeekingIterator> iterators) {
        //iterate and find min value
    }
}
