# Subsets II (with Duplicates) - Documentation

## Problem
Given an integer array that may contain duplicates, return all possible subsets (the power set). The solution set must not contain duplicate subsets.

## What is a Subset?
A subset is a collection of elements from the original array:
- Can be empty: `[]`
- Can contain some elements: `[1,2]`
- Can contain all elements: `[1,2,2]`
- **Order doesn't matter**: `[1,2]` is same as `[2,1]`

## Key Challenge
**Avoiding duplicate subsets** when input has duplicate elements:
- Input: `[1,2,2]`
- We should get `[1,2]` only once, not twice

## Logic Explanation

### How it Works
The solution uses **backtracking** with duplicate handling:

1. **Sort the array** - groups duplicate elements together
2. **Generate subsets level by level** - for each element, decide to include or exclude
3. **Skip duplicates at same level** - avoid generating duplicate subsets
4. **Add every partial subset** - even incomplete ones are valid subsets

### Algorithm Steps
1. Sort the input array to group duplicates
2. Start with empty subset (always add it first)
3. For each position, try including elements from current index onwards
4. Skip duplicate elements at the same recursion level
5. Add current subset to results
6. Recursively generate subsets with remaining elements

### Duplicate Handling
The key line: `if(i > index && arr[i-1] == arr[i]) continue;`
- `i > index`: ensures we only skip duplicates at the same recursion level
- `arr[i-1] == arr[i]`: checks if current element is same as previous

## Dry Run Example
**Input:** nums = [1,2,2]

```
After sorting: [1,2,2]

Start: index = 0, current = [], arr = [1,2,2]

Level 1: Add current subset []
- result.add([]) ✓ Add []

Try elements from index 0:
- Try arr[0] = 1: current = [1], index = 1
  
  Level 2: Add current subset [1]
  - result.add([1]) ✓ Add [1]
  
  Try elements from index 1:
  - Try arr[1] = 2: current = [1,2], index = 2
    
    Level 3: Add current subset [1,2]
    - result.add([1,2]) ✓ Add [1,2]
    
    Try elements from index 2:
    - Try arr[2] = 2: current = [1,2,2], index = 3
      
      Level 4: Add current subset [1,2,2]
      - result.add([1,2,2]) ✓ Add [1,2,2]
      - No more elements, backtrack
    
    - Backtrack: current = [1,2]
  
  - Try arr[2] = 2: current = [1,2], index = 3
    - But arr[2] == arr[1] and i(2) > index(1), so skip this
  
  - Backtrack: current = [1]

- Try arr[1] = 2: current = [2], index = 2
  
  Level 2: Add current subset [2]
  - result.add([2]) ✓ Add [2]
  
  Try elements from index 2:
  - Try arr[2] = 2: current = [2,2], index = 3
    - result.add([2,2]) ✓ Add [2,2]

- Skip arr[2] = 2: Because arr[2] == arr[1] and i(2) > index(0)
  This prevents duplicate subsets
```

**Final Result:** `[[], [1], [1,2], [1,2,2], [2], [2,2]]`

## Why We Add Every Subset
Unlike permutations where we wait for completion, in subsets:
- Every partial combination is a valid subset
- We add `current` to results at the beginning of each recursive call
- This includes the empty subset `[]`

## Code Structure
- **Main Method:** `subsetsWithDup(int[] arr)` - sorts array and starts generation
- **Helper Method:** `generateSubsets(...)` - recursive function that builds subsets
- **Parameters:**
  - `index`: starting position for current level
  - `arr`: sorted input array
  - `current`: current subset being built
  - `result`: list to store all unique subsets

## Comparison with Subsets I
| Aspect | Subsets I | Subsets II |
|--------|-----------|------------|
| Input | No duplicates | May have duplicates |
| Sorting | Not needed | Required |
| Duplicate handling | None | Skip at same level |
| Complexity | Simpler | More complex |

## Time & Space Complexity
- **Time:** O(N × 2^N) where N is array length
  - 2^N possible subsets
  - N time to copy each subset
- **Space:** O(N × 2^N) for storing all subsets + O(N) for recursion depth

## Key Insight
Sorting + skipping duplicates at the same recursion level ensures we generate each unique subset exactly once, even with duplicate input elements. 