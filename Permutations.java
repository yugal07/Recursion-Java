// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

// Example 1:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:

// Input: nums = [0,1]
// Output: [[0,1],[1,0]]
// Example 3:

// Input: nums = [1]
// Output: [[1]]
 

// Constraints:

// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// All the integers of nums are unique.

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int arr[]){
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(result, new ArrayList<>(), arr);
        return result;
    }
    public static void generatePermutations(List<List<Integer>> result , List<Integer> current , int [] arr){
        if(current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0 ; i  <arr.length ; i++) {
            if(current.contains(arr[i]))  continue;

            current.add(arr[i]);
            generatePermutations(result, current, arr);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
}
