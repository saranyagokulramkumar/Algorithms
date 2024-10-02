import java.sql.Array;
import java.util.*;

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
