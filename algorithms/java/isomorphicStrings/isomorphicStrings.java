package isomorphicStrings;

import java.util.HashMap;

//todo
public class isomorphicStrings {
/*
    The main idea is to store the last seen positions of current (i-th) characters in both strings. If previously stored
     positions are different then we know that the fact they're occuring in the current i-th position simultaneously is
     a mistake. We could use a map for storing but as we deal with chars which are basically ints and can be used as
     indices we can do the whole thing with an array.
*/

    public boolean isIsomorphicHashMap(String s, String t) {
        if (s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a).equals(b))
                    continue;
                else
                    return false;
            } else {
                if (!map.containsValue(b))
                    map.put(a, b);
                else return false;

            }
        }
        return true;

    }

    public boolean isIsomorphicBest(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        int[] book = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int cs = (int) s.charAt(i);
            int ts = (int) t.charAt(i);
            if (map[cs] == 0 && book[ts] == 0) {
                map[cs] = ts;
                book[ts] = 1;
            } else if (map[cs] != ts)
                return false;
        }
        return true;
    }


}
