# Combination Sum II - Documentation

## Problem
Given an array of numbers (with possible duplicates) and a target sum, find all unique combinations where the numbers add up to the target. Each number can only be used once in each combination.

## Key Differences from Combination Sum I
- Numbers can have duplicates in the input array
- Each number can only be used once per combination
- Must avoid duplicate combinations in the result

## Logic Explanation

### How it Works
The solution uses **backtracking** with special handling for duplicates:

1. **Sort the array first** - this groups duplicate numbers together
2. **Skip duplicate numbers** at the same recursion level to avoid duplicate combinations
3. **Use each number at most once** by moving to the next index after using a number

### Algorithm Steps
1. Sort the input array to group duplicates together
2. Start backtracking from index 0
3. For each position, try using numbers from current index onwards
4. Skip duplicates at the same level (but allow using duplicates in deeper levels)
5. Add current number to combination and recurse with remaining target
6. Remove number (backtrack) and try next number

### Duplicate Handling
The key line: `if(i > start && arr[i] == arr[i-1]) continue;`
- `i > start`: ensures we only skip duplicates at the same recursion level
- `arr[i] == arr[i-1]`: checks if current number is same as previous

## Dry Run Example
**Input:** candidates = [1,1,2,5,6,7,10], target = 8

```
After sorting: [1,1,2,5,6,7,10]

Start: target = 8, current = [], start = 0

Level 1: Try numbers from index 0
- Try arr[0] = 1: current = [1], target = 7, start = 1
  
  Level 2: Try numbers from index 1
  - Try arr[1] = 1: current = [1,1], target = 6, start = 2
    
    Level 3: Try numbers from index 2
    - Try arr[2] = 2: current = [1,1,2], target = 4, start = 3
    - Try arr[3] = 5: current = [1,1,5], target = 1, start = 4
    - Try arr[4] = 6: current = [1,1,6], target = 0 ✓ Add [1,1,6]
    
  - Skip arr[2] = 2: current = [1,2], target = 5, start = 3
    - Try arr[3] = 5: current = [1,2,5], target = 0 ✓ Add [1,2,5]
    
  - Try arr[4] = 6: current = [1,6], target = 1, start = 5
  - Try arr[5] = 7: current = [1,7], target = 0 ✓ Add [1,7]

- Skip second 1 (i=1, start=0, arr[1]==arr[0]) - avoids duplicate combinations
- Try arr[2] = 2: current = [2], target = 6, start = 3
  - Try arr[4] = 6: current = [2,6], target = 0 ✓ Add [2,6]
```

**Final Result:** `[[1,1,6], [1,2,5], [1,7], [2,6]]`

## Code Structure
- **Main Method:** `combinationSum(int[] arr, int target)` - sorts array and starts backtracking
- **Helper Method:** `helper(...)` - recursive function that finds combinations
- **Parameters:**
  - `arr`: sorted input array
  - `target`: remaining sum needed
  - `result`: list to store all valid combinations
  - `current`: current combination being built
  - `start`: starting index for current level

## Why Sorting is Important
Sorting groups duplicates together, making it easy to skip them:
- `[1,2,1,5]` becomes `[1,1,2,5]`
- Now we can easily skip the second `1` at the same recursion level

## Time & Space Complexity
- **Time:** O(2^N) in worst case, where N is array length
- **Space:** O(target) for recursion depth + space for storing results 