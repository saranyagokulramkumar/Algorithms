/*
**Approach**
Backtracking
1. Initial state = index = 0, nums, subset = empty, result = empty
2. Sort the nums array
3. Call the recursive function with this state
4. Inside the recursive function, add the current subset to the result
5. Iterate from i = index to nums.length
*  if i > index and element at i is the same as element at i-1, continue (skipping duplicates)
*  add the element at i to the subset
*  invoke recursive function with state= i+1, nums, subset, result
*  remove the last element from the subset

*Time complexity* - O(2^N * N), 2^N to generate the subset and N to add the subset in each recursive call to the result
*Space complexity* - O(2^N * k), k -> average length of all subsets

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();

        Arrays.sort(nums);
        findSubsets(0, nums, subset, result);
        return result;
    }

    private void findSubsets(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){
        result.add(new ArrayList<>(subset));

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1])continue;

            subset.add(nums[i]);
            findSubsets(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }

    }
}
