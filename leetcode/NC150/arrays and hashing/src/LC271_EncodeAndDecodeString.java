import java.util.ArrayList;
import java.util.List;

/*
Approaches:
1. Non-ASCII delimiter like pi to concatenate strings in encode and then split the string in decode using this character.
2. Not always possible to assume character exclusion from given strings. Use escaping and a delimiter like /: between the strings.
Encode() - Start with a string builder and go through the strings, delimit them with "/:"; if a character is a '/' add another '/' to make it "//" and append to string builder,
if not just add the character to the string builder.
Decode() - Start with a string builder, if we find a '/' followed by another '/' we add only one '/' to the string builder;
if we find a '/' followed by a ':', it's delimiter so add the current stringbuilder.toString() to the array list and make a new string builder.
Time complexity -> O(N), Space complexity -> O(k), k -> some space for the delimiter characters in the output.
3. Chunked transfer encoding - idea is to encode each string like -> <length of string>/:<string itself>; helps us to correctly decode the
string using the length instead of needing to use escaping.
Encode() - for each string, append string length followed by "/:" followed by string itself to the string builder
Decode() - start from currentindex 0, get the first occurence index of "/:" from this index, use Integer.parseint to parse the length which is positioned between currentIndex
and delim index, get the substring of this length starting from delim+2 until delim + 2 + length, add this string to the list; update currentindex
Time complexity -> O(N), Space complexity -> O(k)
 */

public class LC271_EncodeAndDecodeString {
    //chunked transfer encoding
    public String encode(List<String> strs){
        StringBuilder encodedString = new StringBuilder();
        for(String str : strs){
            encodedString.append(str.length()).append("/:").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str){
        List<String> decodedStrings = new ArrayList<>();
        int currentIndex = 0;

        while(currentIndex < str.length()){
            // find the delimiter starting from the current index
            int delim = str.indexOf("/:",currentIndex);

            // get the length of the string
            int length = Integer.parseInt(str.substring(currentIndex, delim));

            // get the substring
            String currentString = str.substring(delim + 2, delim + 2 + length);

            // add the string to the list
            decodedStrings.add(currentString);
            currentIndex = delim + 2 + length;
        }
        return decodedStrings;
    }
}
