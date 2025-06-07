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
        if(digits.equals("")) return new ArrayList<>();

        String mappings[] = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
        List<String> result = new ArrayList<>();

        helper(digits, mappings, new StringBuffer(), result, 0);
        return result;
    }
    public static void helper(String digits , String[] mappings , StringBuffer current , List<String> result , int index){
        if(index == digits.length()) {
            result.add(current.toString());
            return;
        }
        String string = mappings[digits.charAt(index) - '0'];
        for(int i = 0 ; i < string.length() ; i++) {
            current.append(string.charAt(i));
            helper(digits, mappings, current, result, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
