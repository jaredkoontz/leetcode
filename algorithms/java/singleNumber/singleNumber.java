package singleNumber;

//todo
public class singleNumber {

    /*we use bitwise XOR to solve this problem :

    first , we have to know the bitwise XOR in java

    0 ^ N = N
    N ^ N = 0
    So..... if N is the single number

    N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N

    = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N

    = 0 ^ 0 ^ ..........^ 0 ^ N

    = N*/

	public int singleNumber(int[] nums) {
		int ans = 0;

		int len = nums.length;
		for (int i = 0; i != len; i++)
			ans ^= nums[i];

		return ans;

	}

}
