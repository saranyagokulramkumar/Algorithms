import java.util.Arrays;

/*
**Approach**
Since we need to find a closer value and not exact threesum, we cannot use the hashset approach. We can use a similar approach to 3sum using two pointers.
* Sort the input array
* Initialize closestSum with Integer.MAX_VALUE
* loop through input array and for each element, invoke the twoSum method and have it return the closestSum
* within the twoSum method, start low at i+1 and high at nums.length-1
* while low < high, calculate the threeSum, check if abs(threeSum) < abs(target - closestSum), if yes update the closestSum with the smaller threeSum
* if threeSum < target, move low pointer close to high by 1
* else move the high pointer close to low by 1
* return closestSum at the end

*Time complexity* - O(N^2) - O(NlogN) to sort the array, O(N) for the outer loop and O(N) for the inner while loop.
*Space complexity* - O(logN) for quick sort based array sort
 */

public class LC16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // sort the input array - O(nlogn)
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;

        // loop through the input array and call twoSum
        for(int i = 0; i < nums.length; i++){
            closestSum = twoSum(nums, target, i, closestSum);
        }

        return closestSum;
    }

    private int twoSum(int[] nums, int target, int i, int closestSum){
        int low = i + 1, high = nums.length - 1;

        while(low < high){
            int threeSum = nums[i] + nums[low] + nums[high];

            if(Math.abs(target - threeSum) < Math.abs(target - closestSum)){
                closestSum = threeSum;
            }

            if(threeSum < target){
                low++;
            }else{
                high--;
            }
        }
        return closestSum;
    }
}
