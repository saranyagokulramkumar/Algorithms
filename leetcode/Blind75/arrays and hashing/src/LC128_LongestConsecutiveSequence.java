import java.util.HashSet;
import java.util.Set;

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
