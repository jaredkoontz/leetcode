package zigZagConversion;

//todo
public class ZigZagConversion {
/*The idea is find the exact index from source string, and add it to the result string. Except the first row and the last row, each row need to add two offset, let call them "zig" and "zag".The initial value of these two paramters are 2(nRows-1). For "zig", the value is always 2(nRows-1), for "zag", the value will be decreased by 2 as the rows increase, and we know that the "zag" value for the first and last row is 0.

        I think this problem is more about mathematic.*/

    public String convert1(String s, int nRows) {
        if (s.length() == 0 || s.length() / nRows < 1 || nRows == 1) return s;

        String result = "";
        int zig = 2 * (nRows - 1);
        int zag = zig;

        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += zig) {
                result += s.charAt(j);
                if (zag < zig && (j + zag) < s.length() && zag > 0) result += s.charAt(j + zag);
            }
            zag -= 2;
        }

        return result;
    }

    /*Create nRows StringBuffers, and keep collecting characters from original string to corresponding StringBuffer.
    Just take care of your index to keep them in bound.*/
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

}

