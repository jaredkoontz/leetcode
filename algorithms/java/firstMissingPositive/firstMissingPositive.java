package firstMissingPositive;
/********************************************************************************** 
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 *
 *
 **********************************************************************************/
//todo
public class firstMissingPositive {
    /*The key here is to use swapping to keep constant space and also make use of the length of the array, which means
    there can be at most n positive integers. So each time we encounter an valid integer, find its correct position and
    swap. Otherwise we continue.*/


        public int firstMissingPositive(int[] A) {
            int i = 0;
            while(i < A.length){
                if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
                else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
                else i++;
            }
            i = 0;
            while(i < A.length && A[i] == i+1) i++;
            return i+1;
        }

        private void swap(int[] A, int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

}
