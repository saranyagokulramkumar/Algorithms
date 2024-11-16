/*
**Approaches**
1. Top-down dp + memoization
* state variables = n, memo
* initial state = n, integer array of length n + 1 (cos we have to reach beyond the nth floor to reach the top)
* edge cases: if n is 1 return 1, there is only 1 way to get to the top
* init the memo array with memo[1] = 1 (there's 1 way to get to top if there's only 1 step), memo[2] = 2 (there are two ways, start from step 1 -> take one step and go to step 2 and take 1 step to go to top floor, second way is to start at step 2 and take 1 step to go to top floor so total 2 ways
* Now call the recursive function with n = n, and the initialized memo array
* base case: if memo[n] > 0 then we already know how many ways we can climb to nth floor
* recurrence relation: invoke the recursive function twice, one if we got to the current step from 1 step back so recursive(n-1,memo) and once if we got to current step from 2 steps back so recursive(n-2,memo). Add results from these two calls to get the total number of ways to climb to the top floor i.e., n.
* return memo[n]

*Time complexity* - O(N)
*Space complexity* - O(N) for the memo and O(N) for the recursive call stack

2. Bottom-up dp + tabulation
* same initialization as the top-down solution
* within the iterative solution, start a for loop from i = 3 to <=n, calculate memo[i] as the sum of ways to reach i from i-1 and i-2 steps, so memo[i] = memo[i-1] + memo[i-2]
* return memo[n]

*Time complexity* - O(N)
*Space complexity* - O(N)
 */
public class LC70_ClimbingStairs {
    public int climbStairsIterative(int n) {
        int[] memo = new int[n + 1];
        if(n == 1)return 1;

        memo[1] = 1;
        memo[2] = 2;

        for(int i = 3; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }

    public int climbStairsRecursive(int n){
        int[] memo = new int[n + 1];
        if(n == 1)return 1;

        memo[1] = 1;
        memo[2] = 2;
        if(memo[n] > 0)return memo[n];

        memo[n] = climbStairsRecursive(n - 1) +
                climbStairsRecursive(n - 2);

        return memo[n];
    }
}
