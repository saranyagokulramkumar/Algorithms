import java.util.HashSet;
import java.util.Stack;

/*
Q-https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
**Approaches**
1. Using Stack and HashSet
* state - stack(pair(character,integer)) to store the character and index, hashset(integer) -> to store the indices of characters to be removed.
* First pass through the string - if char is '(' push to stack along with index; if ')', and stack is empty, push ch and index to stack and continue, else if '(' is present on top of stack, if yes pop the '(' from stack and continue, else push to the stack.
* Go through the remaining characters in the stack (2nd pass) to construct the list of indices to remove characters from into a hashset
* Use a StringBuilder to go through the string (3rd pass) and if index is present in hashset, skip the character else append to stringbuilder
* return sb.tostring()

*Time complexity* - O(3N) -> first pass to construct stack, second for the hashset, third for the stringbuilder.

*Space complexity* - O(N) -> O(N) for stack, hashset, stringbuilder.

2. Without using additional data structures
* state - opencount for open braces, closecount for close braces, stringbuilder
* Idea - we will know immediately if a ')' is not balanced while parsing the string based on the count of open and close braces. We will not know if a '(' is not balanced until t he end of the parsing. So in first pass we only remove unmatched ')' and in second pass we remove unmatched '(' from the right and the string will be guaranteed to be valid.
* First pass - if char is '(' increment opencount and add to sb, if ')', increment closecount, if > opencount, skip this character else append to sb.
* opentokeep = opencount - (opencount - closecount)
* Second pass - if char is ')' or character append to result, if '(' and opentokeep > 0, decrement opentokeep by 1 and append to sb, else if '(' and opentokeep < 0 skip the character.
* return result.tostring()

*Time complexity* - O(2N) -> first pass to remove unmatched ')', second to remove unmatched '('
*Space complexity* - O(N) -> intermediate and result stringbuilder.

 */
public class LC1249_MinimumRemoveValidParentheses {
    public String solutionWithStack(String s) {
        Stack<Pair<Character,Integer>> stack = new Stack<>();
        HashSet<Integer> removalIndices = new HashSet<>();

        // process the string and find the brackets that need to be removed
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(new Pair<>(ch, i));
            }else if(ch == ')'){
                if(stack.isEmpty()){
                    stack.push(new Pair<>(ch, i));
                    continue;
                }

                Pair<Character, Integer> pair = stack.peek();
                if(pair.getKey() == '('){
                    stack.pop();
                }else{
                    stack.push(new Pair<>(ch, i));
                }
            }
        }

        // go through the stack and construct the set of indices to be removed
        while(!stack.isEmpty()){
            Pair<Character, Integer> pair = stack.pop();
            removalIndices.add(pair.getValue());
        }

        // construct the new string
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!removalIndices.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    public String solutionWithoutStack(String s){
        StringBuilder sb = new StringBuilder();
        int openCount = 0, closeCount = 0;

        // Pass 1: remove unwanted ')'
        for(char ch : s.toCharArray()){
            if(ch == '('){
                openCount++;
            }else if(ch == ')'){
                if(closeCount + 1 > openCount){
                    // drop this close bracket
                    continue;
                }else{
                    closeCount++;
                }
            }
            sb.append(ch);
        }

        // Pass 2: remove unbalanced open braces
        int balance = openCount - closeCount;
        int openToKeep = openCount - balance;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < sb.length(); i++){
            char ch = sb.charAt(i);
            if(ch == '('){
                openToKeep--;
                if(openToKeep < 0)continue;
            }
            result.append(ch);
        }
        return result.toString();
    }
}
