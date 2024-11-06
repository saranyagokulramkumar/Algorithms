/*
**Approach**
Backtracking
1. State variables = index, string, current path (List<String>), all paths (List<List<String>>)
2. initial state = 0, string, empty list, empty list
3. Recursive function base case: if index is equal to s.length(), add current path to result and return
4. recursive case: for i = index until s.length(), check if substring from index to i is palindrome, if yes, add it to path and recursively call function with i +1, s, path, result. After that remove the last path from path to backtrack

*Time complexity* - O(2^N * N), 2^N to generate all partitions and N to check if each substring is palindrome
*Space complexity* - O(N), depth of the recursive call stack given N is the lenght of the string.
 */
import java.util.ArrayList;
import java.util.List;

public class LC131_PalindromPartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList();
        List<String> path = new ArrayList();

        findPartitions(0, s, path, result);
        return result;
    }

    private void findPartitions(int index, String s, List<String> path, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index, i)){
                path.add(s.substring(index, i+1));
                findPartitions(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))return false;
        }
        return true;
    }
}
