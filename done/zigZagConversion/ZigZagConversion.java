package zigZagConversion;

//todo
public class ZigZagConversion {
/*The idea is find the exact index from source string, and add it to the result string. Except the first row and the last row, each row need to add two offset, let call them "zig" and "zag".The initial value of these two paramters are 2(nRows-1). For "zig", the value is always 2(nRows-1), for "zag", the value will be decreased by 2 as the rows increase, and we know that the "zag" value for the first and last row is 0.

        I think this problem is more about mathematic.*/

    public String convert(String s, int nRows) {
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
}

