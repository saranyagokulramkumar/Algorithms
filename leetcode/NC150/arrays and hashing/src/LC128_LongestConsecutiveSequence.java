import java.util.HashSet;
import java.util.Set;

/*
**Approaches**
1. Brute-force
* For each number in the list, loop through and count + 1 as much as possible ensuring that the number + 1 is present in the given input array.
* Update the streak to the maximum of the streak seen so far and the current streak
* Return the longestStreak

*Time complexity* - O(N^3), O(N) time to go through each number in the input, O(N) time to increment each time until contiguous elements are present in the array, O(N) time to lookup each time if the number + 1 is present in the array.
*Space complexity*  - O(1)

2. Sorting
*  Sort the input array
*  Now go through the array and check if nums[i] and nums[i-1] are not equal, if so check if nums[i] = nums[i-1] + 1, if so increase the current streak else update the longest streak and reset current streak to 1

*Time complexity* - O(nlogn)
*Space complexity* - O(logn) space complexity for Arrays.sort() in java.

3. HashSet
*  Add all elements to hashset
*  for each number in the input array, check if num-1 is not present in the hashset, if it doesnt, this is the beginning of a new streak.
*  while set contains num + 1, keep increasing the current streak and currentnum by 1.
*  After all of the contiguous numbers are exhausted, update the longest streak and return it.

*Time complexity* - O(N), elements in the array are accessed twice (add to hashset, check existence in hashset (O(1)).
*Space complexity* - O(N), hashset.
 */
public class LC128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbersSet = new HashSet();

        for(int num : nums){
            numbersSet.add(num);
        }

        int longestStreak = 0;

        for(int num : numbersSet){
            if(!numbersSet.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;

                while(numbersSet.contains(currentNum + 1)){
                    currentStreak += 1;
                    currentNum += 1;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }

        return longestStreak;
    }
}
