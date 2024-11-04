/*
**Approach**
Backtracking
1. State variables - current index, candidates array, target, current combination, list of combinations
2. Initial state = 0, candidates, target, empty list, empty list
3. base case for the recursive function: if index is equal to array length, we have explored all candidates in this chain of recursive calls, if the target = 0 add the current combination to the list of combinations.
4. if index is equal to array length, but target != 0 then simply return, summing to target is not possible from the current path.
5. Recursive case: if candidates[index] <= target (pruning):
*  add candidates[index] to current combination
*  recursive function call with state = index, candidates, target - candidates[index], combination, result
*  remove last element from the combination list
6. recursive funciton call with state = index + 1, candidates, target, combination, result

*Time complexity* - O(2^t * k), t = target, k = average length of all combinations (time needed to add a combination in the base case to result)
*Space complexity* - O(k * x), k = average length of all combinations, x = number of combinations
 */

import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> combination = new ArrayList();

        findCombinations(0, candidates, target, combination, result);
        return result;
    }

    private void findCombinations(int index, int[] candidates, int target, List<Integer>
            combination, List<List<Integer>> result){
        if(index == candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if(candidates[index] <= target){
            combination.add(candidates[index]);
            findCombinations(index, candidates, target - candidates[index], combination,result);
            combination.remove(combination.size() - 1);
        }
        findCombinations(index + 1, candidates, target, combination, result);
    }
}
