# Combination Sum - Documentation

## Problem
Given an array of distinct integers and a target sum, find all unique combinations where the chosen numbers sum to the target. The same number may be used multiple times.

## Logic Explanation

### How it Works
The solution uses **backtracking** to explore all possible combinations:

1. **Try each number** in the array as a potential part of the solution
2. **Reuse numbers** - since we can use the same number multiple times
3. **Keep track of remaining target** - subtract current number from target
4. **Backtrack** when we can't proceed further

### Algorithm Steps
1. Start with the full target and empty combination
2. For each number in array (starting from a given index):
   - If number ≤ remaining target, it's a valid choice
   - Add number to current combination
   - Recursively try to complete the combination (allowing reuse of same number)
   - Remove number from combination (backtrack) and try next number
3. When target becomes 0, we found a valid combination

### Key Insight
We use the same starting index `i` in the recursive call `helper(arr, target - arr[i], i, current, result)` because we can reuse the same number multiple times.

## Dry Run Example
**Input:** candidates = [2,3,6,7], target = 7

```
Start: target = 7, current = [], start = 0

Level 1: Try numbers from index 0
- Try arr[0] = 2: target = 5, current = [2], start = 0
  
  Level 2: Try numbers from index 0 (can reuse)
  - Try arr[0] = 2: target = 3, current = [2,2], start = 0
    
    Level 3: Try numbers from index 0
    - Try arr[0] = 2: target = 1, current = [2,2,2], start = 0
      - arr[0] = 2 > target = 1, skip
      - arr[1] = 3 > target = 1, skip
      - No valid numbers, backtrack
    
    - Try arr[1] = 3: target = 0, current = [2,2,3] ✓ Add [2,2,3]
  
  - Try arr[1] = 3: target = 2, current = [2,3], start = 1
    - arr[1] = 3 > target = 2, skip
    - No valid numbers, backtrack
  
  - Try arr[2] = 6 > target = 5, skip
  - Try arr[3] = 7 > target = 5, skip

- Try arr[1] = 3: target = 4, current = [3], start = 1
  - Try arr[1] = 3: target = 1, current = [3,3], start = 1
    - No numbers ≤ 1, backtrack
  - Try arr[2] = 6 > target = 4, skip
  - Try arr[3] = 7 > target = 4, skip

- Try arr[2] = 6: target = 1, current = [6], start = 2
  - No numbers ≤ 1, backtrack

- Try arr[3] = 7: target = 0, current = [7] ✓ Add [7]
```

**Final Result:** `[[2,2,3], [7]]`

## Code Structure
- **Main Method:** `combinationSum(int[] arr, int target)` - starts the backtracking process
- **Helper Method:** `helper(...)` - recursive function that finds combinations
- **Parameters:**
  - `arr`: input array of candidates
  - `target`: remaining sum needed
  - `start`: starting index to avoid duplicate combinations
  - `current`: current combination being built
  - `result`: list to store all valid combinations

## Why We Use Start Index
The `start` parameter ensures we don't create duplicate combinations:
- Without it: we might get both `[2,3]` and `[3,2]`
- With it: we only get `[2,3]` because we only consider numbers from current index onwards

## Key Differences from Other Problems
- **Reuse allowed**: Same number can be used multiple times
- **No duplicates in input**: All numbers in candidates array are distinct
- **Start index stays same**: When recursing with same number (for reuse)

## Time & Space Complexity
- **Time:** O(N^(T/M)) where N is array length, T is target, M is minimal value in array
- **Space:** O(T/M) for recursion depth + space for storing results 