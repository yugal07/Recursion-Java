// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

// Example 1:

// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// Example 2:

// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

// Constraints:

// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int arr[]){
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[arr.length];
        generatePermutations(arr, result, new ArrayList<>(), used);
        return result;
    }

    public static void generatePermutations(int[] arr , List<List<Integer>> result , List<Integer> current , boolean[] used){
        if(current.size() == arr.length ){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0 ; i < arr.length ; i++) {
            if(used[i]) continue;

            if(i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.add(arr[i]);
            generatePermutations(arr, result, current, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
