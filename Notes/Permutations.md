# Permutations - Documentation

## Problem
Given an array of distinct integers, return all possible permutations. You can return the answer in any order.

## What is a Permutation?
A permutation is an arrangement of all elements where **order matters**:
- For `[1,2,3]`: `[1,2,3]` and `[2,1,3]` are different permutations
- Total permutations for n distinct elements = n! (n factorial)

## Logic Explanation

### How it Works
The solution uses **backtracking** to build permutations step by step:

1. **Choose** an unused element for current position
2. **Add** it to current permutation
3. **Recursively** build rest of the permutation
4. **Remove** the element (backtrack) and try next unused element

### Algorithm Steps
1. Start with empty permutation
2. For each position in the permutation:
   - Try each unused element from the original array
   - Add element to current permutation
   - Recursively fill remaining positions
   - Remove element (backtrack) and try next element
3. When permutation length equals array length, we have a complete permutation

### Key Point
We use `current.contains(arr[i])` to check if an element is already used in the current permutation.

## Dry Run Example
**Input:** nums = [1,2,3]

```
Start: current = [], arr = [1,2,3]

Level 1: Choose first element
- Try 1: current = [1]
  
  Level 2: Choose second element (1 already used)
  - Skip 1 (already in current)
  - Try 2: current = [1,2]
    
    Level 3: Choose third element (1,2 already used)
    - Skip 1 (already used)
    - Skip 2 (already used)
    - Try 3: current = [1,2,3], length = 3 ✓ Add [1,2,3]
    - Backtrack: current = [1,2]
  
  - Try 3: current = [1,3]
    
    Level 3: Choose third element (1,3 already used)
    - Skip 1 (already used)
    - Try 2: current = [1,3,2], length = 3 ✓ Add [1,3,2]
    - Backtrack: current = [1,3]
    - Skip 3 (already used)
  
  - Backtrack: current = [1]

- Try 2: current = [2]
  
  Level 2: Choose second element (2 already used)
  - Try 1: current = [2,1]
    - Try 3: current = [2,1,3] ✓ Add [2,1,3]
  
  - Skip 2 (already used)
  - Try 3: current = [2,3]
    - Try 1: current = [2,3,1] ✓ Add [2,3,1]

- Try 3: current = [3]
  
  Level 2: Choose second element (3 already used)
  - Try 1: current = [3,1]
    - Try 2: current = [3,1,2] ✓ Add [3,1,2]
  
  - Try 2: current = [3,2]
    - Try 1: current = [3,2,1] ✓ Add [3,2,1]
```

**Final Result:** `[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]`

## Code Structure
- **Main Method:** `permute(int[] arr)` - starts the permutation generation
- **Helper Method:** `generatePermutations(...)` - recursive function that builds permutations
- **Parameters:**
  - `result`: list to store all permutations
  - `current`: current permutation being built
  - `arr`: original input array

## Alternative Approach
Instead of using `contains()` check, we could use a boolean array to track used elements:
```java
boolean[] used = new boolean[arr.length];
// Check used[i] instead of current.contains(arr[i])
```

## Time & Space Complexity
- **Time:** O(N! × N) where N is array length
  - N! permutations to generate
  - N time to copy each permutation and check contains()
- **Space:** O(N! × N) for storing all permutations + O(N) for recursion depth

## Key Characteristics
- **Input**: Array with distinct elements (no duplicates)
- **Output**: All possible arrangements of the elements
- **Order matters**: `[1,2,3]` ≠ `[3,2,1]`
- **All elements used**: Each permutation contains all original elements exactly once 