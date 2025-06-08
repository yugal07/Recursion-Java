# Permutations II - Documentation

## Problem
Given an array of numbers that may contain duplicates, return all possible unique permutations in any order.

## Key Differences from Permutations I
- **Input may have duplicates**: e.g., `[1,1,2]`
- **Output must be unique**: avoid duplicate permutations like having `[1,1,2]` twice
- **Need special handling**: to skip duplicate permutations

## Logic Explanation

### How it Works
The solution uses **backtracking** with duplicate handling:

1. **Sort the array** - groups duplicate elements together
2. **Use boolean array** - track which elements are currently used
3. **Skip duplicates intelligently** - avoid generating duplicate permutations
4. **Backtrack** - try all possibilities systematically

### Algorithm Steps
1. Sort the input array to group duplicates together
2. Create a boolean array to track used elements
3. For each position in permutation:
   - Try each unused element
   - Skip duplicates at the same level using special condition
   - Mark element as used and recurse
   - Unmark element (backtrack) and try next
4. When permutation is complete, add to results

### Duplicate Handling - The Key Logic
```java
if(i > 0 && arr[i] == arr[i - 1] && used[i - 1]) continue;
```

This condition skips duplicates when:
- `arr[i] == arr[i - 1]`: current element equals previous element
- `used[i - 1]`: previous duplicate is currently being used
- This ensures we use duplicates in order (left to right)

## Dry Run Example
**Input:** nums = [1,1,2]

```
After sorting: [1,1,2]
used = [false, false, false]

Start: current = [], used = [F,F,F]

Level 1: Choose first element
- Try arr[0] = 1: current = [1], used = [T,F,F]
  
  Level 2: Choose second element
  - Skip arr[0] = 1 (used[0] = true)
  - Try arr[1] = 1: current = [1,1], used = [T,T,F]
    
    Level 3: Choose third element
    - Skip arr[0] = 1 (used[0] = true)
    - Skip arr[1] = 1 (used[1] = true)
    - Try arr[2] = 2: current = [1,1,2] ✓ Add [1,1,2]
    - Backtrack: current = [1,1], used = [T,T,F]
  
  - Try arr[2] = 2: current = [1,2], used = [T,F,T]
    
    Level 3: Choose third element
    - Skip arr[0] = 1 (used[0] = true)
    - Try arr[1] = 1: current = [1,2,1] ✓ Add [1,2,1]
    - Skip arr[2] = 2 (used[2] = true)
  
  - Backtrack: current = [1], used = [T,F,F]

- Skip arr[1] = 1: Because arr[1] == arr[0] and used[0] = true
  This prevents duplicate permutations starting with the second 1

- Try arr[2] = 2: current = [2], used = [F,F,T]
  
  Level 2: Choose second element
  - Try arr[0] = 1: current = [2,1], used = [T,F,T]
    - Try arr[1] = 1: current = [2,1,1] ✓ Add [2,1,1]
  
  - Try arr[1] = 1: current = [2,1], used = [F,T,T]
    - Try arr[0] = 1: current = [2,1,1] (duplicate, but algorithm handles it)
```

**Final Result:** `[[1,1,2], [1,2,1], [2,1,1]]`

## Why Sorting is Crucial
Sorting groups duplicates together:
- `[1,2,1]` becomes `[1,1,2]`
- Now duplicates are adjacent, making it easy to handle them

## The Skip Condition Explained
`if(i > 0 && arr[i] == arr[i - 1] && used[i - 1]) continue;`

**Why `used[i-1]` and not `!used[i-1]`?**
- We want to use duplicates in order (left to right)
- If `used[i-1] = true`, it means we're trying to use the second duplicate while the first is still in use
- This would create the same permutation, so we skip it

## Code Structure
- **Main Method:** `permuteUnique(int[] arr)` - sorts array and starts backtracking
- **Helper Method:** `generatePermutations(...)` - recursive function with duplicate handling
- **Parameters:**
  - `arr`: sorted input array
  - `result`: list to store unique permutations
  - `current`: current permutation being built
  - `used`: boolean array tracking used elements

## Time & Space Complexity
- **Time:** O(N! × N) in worst case (when all elements are unique)
- **Space:** O(N! × N) for storing results + O(N) for recursion depth and used array

## Key Insight
The duplicate handling ensures we generate each unique permutation exactly once, even when the input contains duplicate elements. 