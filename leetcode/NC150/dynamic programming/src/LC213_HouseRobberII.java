/*
Q-https://leetcode.com/problems/house-robber-ii/description/
**Approach**
Dynamic programming
1. state variables = nums array, start postiion in the array, end postition in the array
2. if arraylength is 1 return nums[0] since that's the maximum profit that can be made
3. if arraylength is 2 return max of nums[0] and nums[1]
4. keep a hellper function that does the same logic as the house robber 1, call this function twice, once including the first house and excluding the last house by specifying start = 0 and end = nums.length -2, and second time excludign the first house and including the last house with start = 1 and end = nums.length -1
5. in the helper function, create a dp array with dp[start] = nums[start], dp[start + 1] = max of nums[start], nums[start+1]
6. now for houses starting start+2 until end, compute dp[house] using the recurrence relation: math.max(dp[house-1], dp[house-2]+nums[house])
7. return dp[end]

*Time complexity* - O(N), recursion from N to 0
*Space complexity* - O(N), recursive call stack + O(N) for the dp array
 */
public class LC213_HouseRobberII {
    public int rob(int[] nums) {

        int arrayLength = nums.length;
        if(arrayLength == 1)return nums[0];
        if(arrayLength == 2)return Math.max(nums[0],nums[1]);

        int robFirstHouse = robSimple(nums, 0, nums.length - 2);
        int robLastHouse = robSimple(nums, 1, nums.length - 1);

        return Math.max(robFirstHouse, robLastHouse);
    }

    private int robSimple(int[] nums, int start, int end){

        int length = end - start + 2;
        int[] dp = new int[length];

        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);

        for(int house = start + 2; house <= end; house++){
            dp[house] = Math.max(dp[house-1], dp[house-2] + nums[house]);
        }

        return dp[end];
    }
}
