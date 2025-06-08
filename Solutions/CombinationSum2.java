// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]
// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static List<List<Integer>> combinationSum(int arr [], int target){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        helper(arr, target, result, new ArrayList<>(), 0);
        return result;
    }
    public static void helper(int arr[] , int target , List<List<Integer>> result , List<Integer> current , int start){
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = start ; i < arr.length ; i++) {
            if(arr[i] <= target){
                if(i > start && arr[i] == arr[i-1]) continue;

                current.add(arr[i]);
                helper(arr, target - arr[i], result, current, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
    
}
