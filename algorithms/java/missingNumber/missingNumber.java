package missingNumber;

/**
 * Created by jared on 10/27/15.
 */
public class missingNumber {
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

/*
Pretty simple since we are told that we are missing only one number in [1,n], we just need to look at the difference
between the sum([1,n]) = n * (n+1) / 2 and the sum of nums in our array.
*/
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int basic;
        int sum = 0;
        if(n%2 == 0) basic =n/2;   //according to the formula n*(n+1)/2, if n is even, add n/2 for n+1 times, otherwise, add (n+1)/2 for n times;
        else basic = (n+1)/2;
        for(int i=0;i<n;++i)
        {
            sum = sum + basic - nums[i];
        }
        if(n%2 == 0) sum += basic;
        return sum;
    }

}
