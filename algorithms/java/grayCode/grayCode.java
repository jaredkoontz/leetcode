package grayCode;

import java.util.LinkedList;
import java.util.List;

//todo
public class grayCode {
    /*
        The purpose of this function is to convert an unsigned
        binary number to reflected binary Gray code.

        The operator >> is shift right. The operator ^ is exclusive or.

    unsigned int binaryToGray(unsigned int num)
    {
        return (num >> 1) ^ num;
    }


        The purpose of this function is to convert a reflected binary
        Gray code number to a binary number.

    unsigned int grayToBinary(unsigned int num)
    {
        unsigned int mask;
        for (mask = num >> 1; mask != 0; mask = mask >> 1)
        {
            num = num ^ mask;
        }
        return num;
    }
*/
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
