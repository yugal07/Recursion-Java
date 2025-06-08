# Recursive Binary Search - Documentation

## Problem
Search for a target element in a sorted array using binary search implemented recursively.

## What is Binary Search?
Binary search is an efficient algorithm to find an element in a **sorted array**:
- **Divide and conquer** approach
- **Eliminates half** of the search space in each step
- **Time complexity**: O(log N) instead of O(N) for linear search

## Logic Explanation

### How it Works
The recursive binary search works by:

1. **Find the middle element** of current search range
2. **Compare with target**:
   - If middle == target: Found! Return index
   - If middle > target: Search in left half
   - If middle < target: Search in right half
3. **Repeat** with the new smaller range
4. **Base case**: If start > end, element not found

### Algorithm Steps
1. Calculate middle index: `mid = start + (end - start) / 2`
2. Compare `arr[mid]` with target:
   - Equal: return mid
   - Greater: search left half `[start, mid-1]`
   - Smaller: search right half `[mid+1, end]`
3. Recursive call with new range
4. Return -1 if range becomes invalid (start > end)

### Why `start + (end - start) / 2`?
Instead of `(start + end) / 2` to avoid integer overflow when start and end are large numbers.

## Dry Run Example
**Input:** arr = [1,2,3,4,5], target = 4, start = 0, end = 4

```
Call 1: binarySearch([1,2,3,4,5], 4, 0, 4)
- start = 0, end = 4
- mid = 0 + (4-0)/2 = 2
- arr[2] = 3
- 3 < 4, so search right half
- Return binarySearch([1,2,3,4,5], 4, 3, 4)

Call 2: binarySearch([1,2,3,4,5], 4, 3, 4)
- start = 3, end = 4
- mid = 3 + (4-3)/2 = 3
- arr[3] = 4
- 4 == 4, found target!
- Return 3
```

**Result:** Index 3 (element found at position 3)

## Another Example - Element Not Found
**Input:** arr = [1,2,3,4,5], target = 6, start = 0, end = 4

```
Call 1: binarySearch([1,2,3,4,5], 6, 0, 4)
- start = 0, end = 4
- mid = 2, arr[2] = 3
- 3 < 6, search right half
- Return binarySearch([1,2,3,4,5], 6, 3, 4)

Call 2: binarySearch([1,2,3,4,5], 6, 3, 4)
- start = 3, end = 4
- mid = 3, arr[3] = 4
- 4 < 6, search right half
- Return binarySearch([1,2,3,4,5], 6, 4, 4)

Call 3: binarySearch([1,2,3,4,5], 6, 4, 4)
- start = 4, end = 4
- mid = 4, arr[4] = 5
- 5 < 6, search right half
- Return binarySearch([1,2,3,4,5], 6, 5, 4)

Call 4: binarySearch([1,2,3,4,5], 6, 5, 4)
- start = 5, end = 4
- start > end, base case reached
- Return -1 (not found)
```

**Result:** -1 (element not found)

## Code Structure
- **Method:** `binarySearch(int[] arr, int target, int start, int end)`
- **Parameters:**
  - `arr`: sorted input array
  - `target`: element to search for
  - `start`: starting index of current search range
  - `end`: ending index of current search range
- **Return:** index of target if found, -1 otherwise

## Base Case
```java
if(start > end) return -1;
```
This happens when the search range becomes invalid, meaning the element is not in the array.

## Recursive Cases
1. **Found**: `arr[mid] == target` → return mid
2. **Search left**: `arr[mid] > target` → search `[start, mid-1]`
3. **Search right**: `arr[mid] < target` → search `[mid+1, end]`

## Advantages of Recursive Approach
1. **Clean and readable** code
2. **Natural divide-and-conquer** implementation
3. **Easy to understand** the logic flow

## Disadvantages
1. **Function call overhead** - each recursive call uses stack space
2. **Stack overflow risk** for very large arrays (though unlikely with log N depth)

## Time & Space Complexity
- **Time:** O(log N) where N is array length
- **Space:** O(log N) for recursion stack (vs O(1) for iterative version)

## Prerequisites
- **Array must be sorted** - binary search only works on sorted data
- **No duplicates handling** - this version returns any occurrence if duplicates exist

## When to Use
- When you need to search in a sorted array efficiently
- When recursive implementation is preferred for readability
- When the array size is reasonable (to avoid stack overflow) 