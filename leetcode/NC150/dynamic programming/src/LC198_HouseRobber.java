/*
Q - https://leetcode.com/problems/house-robber/description/
**Approaches**
1. Recursive + memoization

* state variables = current step, dp array, nums
* initial state = call the recursive function with current step = nums.length -1, dp array with nums.length elements initialized with -1, nums array
* base case: if i = 0, return nums[0] (max profit), if i = 1, return maximum of nums[0] and nums[1], since adjacent houses cannot be robbed so we rob the house that has maximum amount of money. Initialize dp[0] with nums[0] and dp[1] with max of nums[0] and nums[1]
* recurrence relation: dp[i] = max of dp[i-1] and dp[i-2] + nums[i], cos we can rob prev house and not rob current, or rob house 2 before and the current house, whichever gives the maximum
* return dp[nums.length -1]

*Time complexity* - O(N), top-down from Nth house to 0th
*Space complexity* - O(N), for recursive call stack and O(N) for the dp array of length N

2. Iterative + tabulation

* start with dp[0] = nums[0] and dp[1] = max of nums[0] and nums[1]
* iterate from house 2 to nums.length, for each house calculate max profit using the recurrence relation above
* return dp[nums.length -1]

*Time complexity* - O(N)
*Space complexity* - O(N)

3. Iterative + space optimization

* similar to iterative approach but instead of the dp array, we only make use of two variables to keep track of the prev2 and prev1 profits

*Time complexity* - O(N)
*Space complexity* - O(1), constant space for two additional variables

 */

public class LC198_HouseRobber {
    public int recursiveRob(int i, int[] memo, int[] nums) {
        // Base cases
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (memo[i] == -1) {
            memo[i] = Math.max(recursiveRob(i - 1, memo, nums), recursiveRob(i - 2, memo, nums) + nums[i]); // Recurrence relation
        }
        return memo[i];
    }

    public int iterativeRob(int i, int[] memo, int[] nums){
        if(i == 0)return nums[0];
        if(i == 1)return Math.max(nums[0], nums[1]);

        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for(i = 2; i < nums.length; i++){
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }
        return memo[nums.length - 1];
    }

    public int iterativeRobSpaceOptimized(int i, int[] nums){
        if(i == 0)return nums[0];
        if(i == 1)return Math.max(nums[0], nums[1]);

        int prev1 = Math.max(nums[0], nums[1]);
        int prev2 = nums[0];

        for(i = 2; i < nums.length; i++){
            int curri = Math.max(prev1, prev2 + nums[i]);

            prev2 = prev1;
            prev1 = curri;
        }

        return prev1;
    }
}
