/*
**Approaches**
1. Brute Force power set
*  Initialize - List<List<Integer>> result, to hold the resulting subsets, add the empty set to it to start with
* 	For each number in the nums list, create a new List<List<Integer>> to hold all the temporary subsets
* 	For each subset that already exists in the result, copy each one to a temp list and add the current number to it; Add the resulting list to newSubsets
* 	For each subset in newsubsets list, add it to the result.
* 	Return result.

*Time complexity* - O(2^N * N), 2^N time to generate all possible subsets, N time to copy each of the subset for each element in the nums array and it to the subset
	*Space complexity* - O(2^N * N), 2^N subsets of average length N stored in the result list

2. Backtracking
* 	Initialize state - index = 0, current subset with an empty list, result with an empty list and make a call to the recursive function
* 	In the recurisve function, add the current subset to the result
* 	for each index starting from i = index to nums.length, add the element at i to current subset, make a recursive function call with i+1, nums, subset, result, and then remove the last element from the current subset.

	*Time complexity* - O(2^N) to generate all the subsets
	*Space compleixyt* - O(2^N) space to hold all the generated subsets

 */

import java.util.ArrayList;
import java.util.List;

public class LC78_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();

        findSubSets(0, nums, subset, result);
        return result;
    }

    private void findSubSets(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));

        for(int i = index; i < nums.length; i++){
            subset.add(nums[i]);
            findSubSets(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
