/*
Q - https://leetcode.com/problems/min-cost-climbing-stairs/description/
**Approaches**
1. Recursion + memoization

* state variables = current step, dp array, cost array
* initial state = n, dp array filled with -1, cost array
* base case: for steps 0 and 1 return 0 (since we are allowed to start at steps 0 or 1, the min cost to reach these steps is 0)
* recurrence relation: for any step starting i starting at 2, the minCost[i] = minimum of (minCost[i-1] + cost[i-1], minCost[i-2] + cost[i-2])), once we find the minCost[i] we set dp[i] with this value so it is not recomputed for future subproblems that overlap
* return dp[n]

*Time complexity* - O(N), top-down, we go from N to 0 recursive calls
*Space complexity* - O(N), recursive call stack + dp array takes O(N) each

2. Iteration + tabulation

* start with dp array filled with zeroes, so step 0 and 1 will already have the mincost needed to reach these steps
* run a for loop for step = 2 to cost.length + 1 (cos that's the top floor)
* compute the cost to reach current step from 1 step before and 2 steps before it using the recurrence relation
* assign cost to reach current step as Min of two values from above
* return dp[dp.length - 1]

*Time complexity* - O(N), we iterate from steps 2 to N
*Space complexity* - O(N), for the the dp array

3. Iteration + space optimization

* instead of using the dp array of size N, use two variables prev1 and prev2 and initialize to 0 to denote the mincost of reaching steps 0 and 1
* run a for loop for step = 2 to cost.length + 1
* compute the cost to reach current step from 1 step before and 2 steps before it
* make prev2 as prev1 and prev1 as Min of two values from above
* At the end prev1 will contain the answer for mincost to reach step n, return it

*Time complexity* - O(N)
*Space complexity* - O(1), since no extra space is used other than two variables which require constant space


 */
public class LC746_MinCostClimbingStairs {
    public int minCostRecursive(int step, int[] dp, int[] cost){
        if(step <= 1)return 0;

        if(dp[step] != -1)return dp[step];

        int oneStep = minCostRecursive(step - 1, dp, cost) + cost[step - 1];
        int twoStep = minCostRecursive(step - 2, dp, cost) + cost[step - 2];

        return dp[step] = Math.min(oneStep, twoStep);
    }

    public int minCostIterative(int steps, int[] dp, int[] cost){

        for(int step = 2; step < dp.length; step++){
            int oneStep = dp[step - 1] + cost[step - 1];
            int twoStep = dp[step - 2] + cost[step - 2];

            dp[step] = Math.min(oneStep, twoStep);
        }

        return dp[dp.length - 1];
    }

    public int minCostIterativeSpaceOptimized(int steps, int[] cost){
        int prev1 = 0, prev2 = 0;

        for(int step = 2; step < cost.length + 1; step++){
            int oneStep = prev1 + cost[step - 1];
            int twoStep = prev2 + cost[step -2];

            prev2 = prev1;
            prev1 = Math.min(oneStep, twoStep);
        }

        return prev1;
    }
}

