// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = ""
// Output: []
// Example 3:

// Input: digits = "2"
// Output: ["a","b","c"]

import java.util.ArrayList;
import java.util.List;

public class PhoneLettersCombination {
    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        String[] mappings = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "qxyz"};
        helper(0, mappings, digits, result, new StringBuffer());
        return result;
    }
    public static void helper(int index , String[] mappings , String digits, List<String> result , StringBuffer current){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        String string = mappings[digits.charAt(index) - '0'];
        for(int i = 0 ; i < string.length() ; i++) {
            current.append(string.charAt(i));
            helper(index + 1, mappings, digits, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
