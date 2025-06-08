# Subsets (Backtracking Approach) - Documentation

## Problem
Given an integer array of unique elements, return all possible subsets (the power set).

## What is a Subset?
A subset is any combination of elements from the original array:
- **Empty set**: `[]` (always included)
- **Single elements**: `[1]`, `[2]`, `[3]`
- **Multiple elements**: `[1,2]`, `[1,3]`, `[2,3]`
- **All elements**: `[1,2,3]`

For an array of size n, there are **2^n total subsets**.

## Logic Explanation

### How it Works
This solution uses **backtracking** to generate all subsets:

1. **Start with empty subset** - add it to results
2. **For each element** - decide whether to include it or not
3. **Include element** - add to current subset and recurse
4. **Exclude element** - backtrack (remove element) and try next
5. **Repeat** until all elements are processed

### Algorithm Steps
1. Add current subset to results (starts with empty `[]`)
2. For each element from current index onwards:
   - Add element to current subset
   - Recursively generate subsets with remaining elements
   - Remove element (backtrack) and try next element

### Key Insight
We add the current subset to results **at the beginning** of each recursive call, not at the end. This ensures we capture all partial subsets, including the empty one.

## Dry Run Example
**Input:** nums = [1,2,3]

```
Start: index = 0, current = [], nums = [1,2,3]

Level 1: Add current subset []
- result.add([]) ✓ Add []

Try elements from index 0:
- Try nums[0] = 1: current = [1], index = 1
  
  Level 2: Add current subset [1]
  - result.add([1]) ✓ Add [1]
  
  Try elements from index 1:
  - Try nums[1] = 2: current = [1,2], index = 2
    
    Level 3: Add current subset [1,2]
    - result.add([1,2]) ✓ Add [1,2]
    
    Try elements from index 2:
    - Try nums[2] = 3: current = [1,2,3], index = 3
      
      Level 4: Add current subset [1,2,3]
      - result.add([1,2,3]) ✓ Add [1,2,3]
      - No more elements, backtrack
    
    - Backtrack: current = [1,2]
  
  - Try nums[2] = 3: current = [1,3], index = 3
    
    Level 3: Add current subset [1,3]
    - result.add([1,3]) ✓ Add [1,3]
    - No more elements, backtrack
  
  - Backtrack: current = [1]

- Try nums[1] = 2: current = [2], index = 2
  
  Level 2: Add current subset [2]
  - result.add([2]) ✓ Add [2]
  
  Try elements from index 2:
  - Try nums[2] = 3: current = [2,3], index = 3
    - result.add([2,3]) ✓ Add [2,3]

- Try nums[2] = 3: current = [3], index = 3
  
  Level 2: Add current subset [3]
  - result.add([3]) ✓ Add [3]
  - No more elements, backtrack
```

**Final Result:** `[[], [1], [1,2], [1,2,3], [1,3], [2], [2,3], [3]]`

## Code Structure
- **Main Method:** `subsets(int[] nums)` - starts the subset generation
- **Helper Method:** `generateSubsets(...)` - recursive function that builds subsets
- **Parameters:**
  - `index`: starting position for current level
  - `nums`: input array
  - `current`: current subset being built
  - `result`: list to store all subsets

## Time & Space Complexity
- **Time:** O(N × 2^N) where N is array length
- **Space:** O(N × 2^N) for storing all subsets + O(N) for recursion depth 