/*
**Approaches**
1. Backtracking + boolean array
*  state variables = nums, boolean array picked for each element in nums, current permutation, result
*  initial state = nums, empty picked array, empty list of integer for current permutaiton, empty list<list> for result
* 	invoke the recursivefunction with initial state
* 	Within the recursive function, base case: size of current permutation = nums.lenght, add current permutation to result and return
* Recursive case: for i from 0 to nums.length, if picked[i] is false, add it to the permutation, mark it as picked and invoke recursive function with new picked and permutation
* 	reset picked and permutaion to remove the last element on return for backtracking
* return result in main

*Time complexity*- O(n! * n), n! to generate all permutations, n time to add each one to the arraylist within each recursive call.
	*Space complexity* - O(n!) to store the permutations, O(n + n), for the picked array and current permutation.

2. Backtracking + swapping (no extra space)
* state variables = index, nums array, result list<list>
* 	initial state = index = 0, nums, result
* 	recursive function base case : when index == nums.length, add the nums array to an arraylist and add this arraylist to the result. nums array will have the correct order of elements for the current recursive call after necessary swapping.
* 	for i = index to nums.length, swap elements in num at i and index, recursive call with index+1 and swap again to backtrack for elements at i and index

*Time compleixty* - O(n! * n)
	*Space complexity* - O(n!), no additional space for picked array or current permutation
 */

import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> permutation = new ArrayList();
        boolean[] picked = new boolean[nums.length];

        findPermutations(nums, picked, permutation, result);
        return result;
    }

    public List<List<Integer>> permuteBySwap(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> permutation = new ArrayList();
        boolean[] picked = new boolean[nums.length];

        findPermutationsBySwapping(0, nums, result);
        return result;
    }

    private void findPermutations(int[] nums, boolean[] picked, List<Integer> permutation,
                                  List<List<Integer>> result){
        if(permutation.size() == nums.length){
            result.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!picked[i]){
                permutation.add(nums[i]);
                picked[i] = true;
                findPermutations(nums, picked, permutation, result);
                permutation.remove(permutation.size() - 1);
                picked[i] = false;
            }
        }
    }

    private void findPermutationsBySwapping(int index, int[] nums, List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> currentPermutation = new ArrayList<>();
            for(int num : nums){
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for(int i = index; i < nums.length; i++){
            swap(i, index, nums);
            findPermutationsBySwapping(index + 1, nums, result);
            swap(i, index, nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
