import java.sql.Array;
import java.util.*;

/*
**Approaches**
1. Sorting
*  Sort the input array
*  For each element in the array, if nums[i-1] != nums[i] call the twoSumII fucntion which uses a two pointer approach to twoSum problem and calculates the sum = nums[i] + nums[low] + nums[high].
*  Move the low or high pointers based on whether the sum is < 0 or > 0 respectively.
*  If sum equals 0, add the triplet to result list
*  Move the low pointer to the right as long as nums[low] = nums[low-1]

*Time complexity* - O(N^2), O(NlogN) to sort the array, O(N) for the outer loop and O(N) for the twoSumII method.
*Space complexity* - space used by the sorting algorithm. for java it is quick sort and takes O(logN) space.

2. No sorting, HashSet
*  We use a HashSet<List<Integer>> to track duplicate triplets.
* 	For each element in the nums array, we call the twoSum method.
* 	In the twoSum method, we iterate through the input array making sure the current index != i.
* 	Calculate the complement as -(nums[i] + nums[j])
* 	Check if this complement exists in the hashmap<number,index> that we maintain locally in this method && index != j (to avoid picking the same number again)
* 	If above condition holds, make a list of the three numbers and sort it; else add nums[j], j to indices and continue
* 	Check if this triplet exists in the dups hashset, if not add it to the result list and the dups hashset. If yes, skip

*Time complexity* - O(N^2), outer loop takes O(N) and inner loop takes O(N).
*Space complexity* - O(N), for the hashmap/hashset.

 */

public class LC15_3Sum {
    public List<List<Integer>> threeSumSorting(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                twoSumII(i, result, nums);
            }
        }
        return result;
    }

    private void twoSumII(int i, List<List<Integer>> result, int[] nums){
        int low = i + 1, high = nums.length - 1;
        while(low < high){
            int sum = nums[i] + nums[low] + nums[high];
            if(sum < 0){
                low++;
            }else if(sum > 0){
                high--;
            }else{
                result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                while(low < high && nums[low] == nums[low - 1]){
                    low++;
                }
            }
        }
    }

    public List<List<Integer>> threeSumNoSorting(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> dups = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            twoSum(nums, i, result, dups);
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result, HashSet<List<Integer>> dups){
        HashMap<Integer, Integer> indices = new HashMap<>();

        for(int j = 0; j < nums.length && j != i; j++){
            int complement = -(nums[i] + nums[j]);
            if(indices.containsKey(complement) && indices.get(complement) != j){
                List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], complement));
                Collections.sort(triplet);

                // check if it is present in the dups list
                if(!dups.contains(triplet)){
                    result.add(triplet);
                    dups.add(triplet);
                }
            }
            indices.put(nums[j], j);
        }
    }
}
