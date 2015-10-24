package reverseInteger;

//todo

public class ReverseInteger {
    public int reverse(int in) {
        long reversed = 0;
        while (in != 0) {
            int onesColumn = in % 10;
            long moveByTen = reversed * 10;
            reversed = moveByTen + onesColumn;
            in /= 10;
            System.out.println("r " + reversed);
            System.out.println("n " + in);
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
}
