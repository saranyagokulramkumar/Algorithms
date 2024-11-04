/*
**Approaches**
1. Prefix-sum - In this case prefix product:
*  Use two arrays L & R to record the products of numbers to the left and to the right of each index.
*  Start by initializing L[0] = 1 and R[length-1] = 1, then keep multiplying nums[i-1]xL[i-1] for the left and nums[i+1]xR[i+1] for the right array
*  Construct the product array by multiplying the products at each index and return the result

*Time complexity*: O(N) , we traverse the entire array twice.
*Space compleixty*: O(N), L and R arrays take up this space.

2. Prefix-sum, but with O(1) space:
*  Instead of maintaining two arrays to hold the prefix products, maintain just the result array.
*  Start from result[0] = 1 and calculate the products on the left for each index as nums[i-1]xresult[i-1]
*  Now start with R= 1 and calculate the products on the right for each index as result[i] x= R and then R x= nums[i]
*  Return the result

*Time complexity* = O(N), we traverse the array twice.
*Space complexity* = O(1), we only have the result array and a variable R to keep track of the products on the right.
 */

public class LC238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        result[0] = 1;
        for(int i = 1; i < length; i++){
            result[i] = nums[i-1] * result[i-1];
        }

        int R = 1;
        for(int i = length - 1; i >= 0; i--){
            result[i] = result[i] * R;
            R *= nums[i];
        }
        return result;
    }
}
