# Subsets (Iterative Approach) - Documentation

## Problem
Given an integer array of unique elements, return all possible subsets (the power set).

## What is a Subset?
A subset is any combination of elements from the original array. For `[1,2,3]`:
- `[]` (empty set)
- `[1]`, `[2]`, `[3]` (single elements)
- `[1,2]`, `[1,3]`, `[2,3]` (pairs)
- `[1,2,3]` (all elements)

Total subsets = **2^n** where n is array length.

## Logic Explanation

### How it Works (Iterative Approach)
This solution builds subsets **iteratively** instead of using recursion:

1. **Start with empty subset**: `result = [[]]`
2. **For each new element**: 
   - Take all existing subsets
   - Create new subsets by adding current element to each existing subset
   - Add these new subsets to the result
3. **Repeat** for all elements

### Algorithm Steps
1. Initialize result with empty subset: `[[ ]]`
2. For each element in the input array:
   - Get current size of result (number of existing subsets)
   - For each existing subset:
     - Create a copy of the subset
     - Add current element to the copy
     - Add this new subset to result

### Key Insight
We **double the number of subsets** with each new element:
- Start: `[[]]` (1 subset)
- Add 1: `[[], [1]]` (2 subsets)
- Add 2: `[[], [1], [2], [1,2]]` (4 subsets)
- Add 3: `[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]` (8 subsets)

## Dry Run Example
**Input:** nums = [1,2,3]

```
Initial: result = [[]]

Step 1: Process element 1
- Current result size = 1
- Existing subsets: [[]]
- For subset []:
  - Create copy: []
  - Add 1: [1]
  - Add to result: [1]
- Result after step 1: [[], [1]]

Step 2: Process element 2
- Current result size = 2
- Existing subsets: [[], [1]]
- For subset []:
  - Create copy: []
  - Add 2: [2]
  - Add to result: [2]
- For subset [1]:
  - Create copy: [1]
  - Add 2: [1,2]
  - Add to result: [1,2]
- Result after step 2: [[], [1], [2], [1,2]]

Step 3: Process element 3
- Current result size = 4
- Existing subsets: [[], [1], [2], [1,2]]
- For subset []:
  - Create copy: []
  - Add 3: [3]
  - Add to result: [3]
- For subset [1]:
  - Create copy: [1]
  - Add 3: [1,3]
  - Add to result: [1,3]
- For subset [2]:
  - Create copy: [2]
  - Add 3: [2,3]
  - Add to result: [2,3]
- For subset [1,2]:
  - Create copy: [1,2]
  - Add 3: [1,2,3]
  - Add to result: [1,2,3]
- Result after step 3: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

**Final Result:** `[[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]`

## Visual Representation
```
Start:     [[]]
Add 1:     [[], [1]]
Add 2:     [[], [1], [2], [1,2]]
Add 3:     [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

## Code Structure
- **Main Method:** `subsets(int[] nums)` - iterative subset generation
- **Key Variables:**
  - `result`: list storing all subsets
  - `n`: current size of result (number of existing subsets)
  - `arr`: temporary list for creating new subsets

## Comparison: Iterative vs Backtracking

| Aspect | Iterative | Backtracking |
|--------|-----------|--------------|
| Approach | Build subsets level by level | Explore all possibilities recursively |
| Space | O(2^N) for result only | O(2^N) + O(N) for recursion stack |
| Understanding | Easier to visualize | Requires recursion understanding |
| Implementation | Simpler loops | More complex recursive logic |

## Advantages of Iterative Approach
1. **No recursion overhead** - uses simple loops
2. **Easier to understand** - clear step-by-step building
3. **Memory efficient** - no call stack usage
4. **Natural order** - generates subsets in a predictable sequence

## Time & Space Complexity
- **Time:** O(N × 2^N) where N is array length
  - 2^N subsets to generate
  - N time to copy each subset on average
- **Space:** O(N × 2^N) for storing all subsets

## When to Use This Approach
- When you want to avoid recursion
- When you need subsets in a specific order
- When working with constraints on recursion depth
- When the iterative logic is easier to understand for your use case 