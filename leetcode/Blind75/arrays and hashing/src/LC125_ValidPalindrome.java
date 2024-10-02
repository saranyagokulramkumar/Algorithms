/*
**Approaches**
1. Brute force - compare the string with it's reverse and return true if all characters match.

*Time complexity* - O(N)
*Space complexity* - O(N)

2. Two pointers - start two pointers, start = 0, end = s.length()- 1; keep incrementing start and decrementing end until we are at characters in the string that are either letters or digits. Now compare the two and if they are not equal immediately return false. Return true at the end.

*Time complexity* - O(N)
*Space complexity* - O(1)
 */
public class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length() < 2)return true;
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            // skip characters that are not alphabet or number
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            // now compare both the characters and if they are equal continue else return false
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))return false;
        }
        return true;
    }
}