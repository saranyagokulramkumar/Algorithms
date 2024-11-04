/*
**Approach**
Backtracking
1. State variables = current index, candidates, target, current combination, result
2. Sort the candidates array
3. Initial state = 0, candidates, target, empty list, empty list
4. Base case = if target is 0, add the current combination to result and return
5. Iterate from i = index to end of the candidates list, exploring solutions with candidates only on the right of the current index. This helps in sorted order of the combination and to skip duplicates since the candidates array is sorted.
*  For each i, if i > index and element at i is the same as element at i-1, skip this
*  If element at i is > target break from the loop, cos further elements will only be greater since the array is sorted
*  add the current element to the combination
*  Recursive function call with state = i+1, candidates, target - candidates[i], combination, result
*  remove the last element from the combination

*Time complexity* - O(2^n * k), O(2^n) for generating all of the combinations, k time for adding a combination in each of these combinations to the list.
*Space complexity* - O(k * x), k - average length of all combinations, x - approximate number of combinations that can be generated.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> combination = new ArrayList();

        Arrays.sort(candidates);
        findCombinations(0, candidates, target, combination, result);
        return result;
    }

    private void findCombinations(int index, int[] candidates, int target, List<Integer>
            combination, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(combination));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i - 1])continue;
            if(candidates[i] > target)break;

            combination.add(candidates[i]);
            findCombinations(i + 1, candidates, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
