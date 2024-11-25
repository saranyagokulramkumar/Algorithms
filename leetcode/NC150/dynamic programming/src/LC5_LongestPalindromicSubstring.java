/*
Q-https://leetcode.com/problems/longest-palindromic-substring/description/
**Approaches**
1. Brute force
* two for loops - outer loop (length) to iterate strings of length = s.length() until length = 1, inner for loop (start) to enumerate strings starting at 0 until s.length - end (to not skip over the end of the string).
* check if substring starting from start until start + end is palindrome, if yes return the substring because it will be the longest. This is because in the outer for loop we start with strings of length = s.length() that goes down until 1. So whichever substring we find first will be the longest.
* if we finish all indices and we don't find a palindrome, return ""

*Time complexity* - O(N^3) - O(N^2) to enumerate all substrings, O(N) to check if each substring is a palindrome
*Space compelxity* - O(1)

2. Dynamic programming with 2D array
* create a 2D dp boolean array of nxn size
* based on the idea that substrings of length 1 are all palindromes, initialize dp[i][i] for all i = 0 to n as true
* next for substrings of length 2, check if characters at indices i & i + 1 in string s, for all i = 0 to n is equal, then mark dp[i][i+1] as true
* Now for all other substrings of length starting 3 to n, if characters in string s at indices i and i + length are equal and dp[i+1][j-1] is true (which means the substring from indices i+1 to j-1 is a palindrome) then mark dp[i][j] as a palindrome as well adn store the indices in result
* return the substring from result[0] to result[1] + 1

*Time complexity* - O(N^2)
*Space complexity* - O(N^2)

3. Two pointers expand from the center
* The idea is based on using two pointers and starting from each index from 0 to n as the center and expand on left and right to see how long of a substring which is also a palindrome we can find
* There can be an odd length palindrome, where the left and right pointers can start at the same center, or an even length palindrome where left and right indices will start at i and i + 1
* Now with each index i = 0 to n as the center, find the length of oddlengthpalindrome and evenlengthpalindromes
* After finding length of both, if the length is greater than the length already stored in the result, get the distance from current center on either sides to get the start and end indices of the substring
* return the substring from result[0] until result[1] + 1

*Time complexity* - O(N^2)
*Space complexity* - O(1)
 */
public class LC5_LongestPalindromicSubstring {
    // Solution 1: Brute force
    public String bruteForce(String s){
        // check all substrings starting from the longest possible one
        for(int end = s.length(); end > 0; end--){
            for(int start = 0; start <= s.length() - end; start++){
                if(isPalindrome(s, start, start + end)){
                    return s.substring(start, start + end);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String s, int start, int end){
        int left = start;
        int right = end - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))return false;
            left++;
            right--;
        }
        return true;
    }

    // Solution 2: Dynamic programming with 2D array
    public String dp(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] result = new int[]{0,0};

        // all substring of length 1 are palindromes
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }

        // check if substrings with consecutive two characters are palindromes (even length)
        for(int i = 0; i < n - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                result[0] = i;
                result[1] = i+1;
            }
        }

        // check all the other substrings of lengths starting 3 and so on
        for(int length = 2; length < n; length++){
            for(int i = 0; i < n - length; i++){
                int j = i + length;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    // Solution 3: Expand from centers
    public String expandFromCenters(String s) {
        int[] result = new int[]{0,0};

        for(int i = 0; i < s.length(); i++){
            int oddLengthPalindrome = expand(s, i, i);
            if(oddLengthPalindrome > result[1] - result[0] + 1){
                int distance = oddLengthPalindrome / 2;
                result[0] = i - distance;
                result[1] = i + distance;
            }

            int evenLengthPalindrome = expand(s, i , i+1);
            if(evenLengthPalindrome > result[1] - result[0] + 1){
                int distance = evenLengthPalindrome / 2 - 1;
                result[0] = i - distance;
                result[1] = i + distance + 1;
            }
        }
        return s.substring(result[0], result[1] + 1);
    }

    private int expand(String s, int i, int j){
        int left = i;
        int right = j;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
