// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

 

// Example 1:

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2:

// Input: nums = [0]
// Output: [[],[0]]
 

// Constraints:

// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsBacktracking2 {
    public static List<List<Integer>> subsetsWithDup(int arr[]) {
        Arrays.sort(arr);
        List <List<Integer>> result = new ArrayList<>();
        generateSubsets(0, arr, new ArrayList<>(), result);
        return result;
    }
    public static void generateSubsets(int index , int arr[] , List<Integer> current , List<List<Integer>> result){
        result.add(new ArrayList<>(current));

        for(int i = index ; i < arr.length ; i++) {
            if(i > index && arr[i-1] == arr[i]) continue;

            current.add(arr[i]);
            generateSubsets(i + 1, arr, current, result);
            current.remove(current.size() - 1);
        }
    }
}
