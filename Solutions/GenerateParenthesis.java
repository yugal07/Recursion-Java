// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:

// Input: n = 1
// Output: ["()"]
 

// Constraints:

// 1 <= n <= 8

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0, n);
        return result;
    }
    public static void helper(List<String> result , String current , int open , int close , int max){
        if(current.length() == max * 2){
            result.add(current);
            return;
        }

        if(open < max){
            helper(result, current + "(", open + 1, close, max);
        }
        if(close < open){
            helper(result, current + ")", open, close + 1, max);
        }
    } 
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
