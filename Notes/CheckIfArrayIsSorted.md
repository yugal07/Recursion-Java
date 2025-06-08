# Check If Array Is Sorted - Documentation

## Problem
Check if an array is sorted in non-decreasing order (ascending order) using recursion.

## What Does "Sorted" Mean?
An array is sorted in **non-decreasing order** if:
- Each element is ≤ the next element
- Example: `[1,2,2,4,5]` is sorted (equal elements are allowed)
- Example: `[1,3,2,4]` is NOT sorted (3 > 2)

## Logic Explanation

### How it Works
The recursive approach checks if array is sorted by:

1. **Base cases**: 
   - Empty array (size 0): Always sorted
   - Single element (size 1): Always sorted
2. **Recursive case**:
   - Check if last two elements are in order
   - If yes, recursively check the rest of the array
   - If no, array is not sorted

### Algorithm Steps
1. If array size is 0 or 1, return true (base case)
2. Compare last element with second-to-last element
3. If `arr[n-1] >= arr[n-2]`, check rest of array recursively
4. If not, return false immediately

### Key Insight
We check from the **end of the array backwards**:
- Compare `arr[n-1]` with `arr[n-2]`
- Then recursively check array of size `n-1`
- This reduces the problem size by 1 each time

## Dry Run Example 1 - Sorted Array
**Input:** arr = [1,2,6,4], n = 4

```
Call 1: isSorted([1,2,6,4], 4)
- n = 4 (not 0 or 1)
- Check: arr[3] >= arr[2] → 4 >= 6? → False
- Return false immediately
```

**Result:** false (array is not sorted because 6 > 4)

## Dry Run Example 2 - Sorted Array
**Input:** arr = [1,2,3,4], n = 4

```
Call 1: isSorted([1,2,3,4], 4)
- n = 4 (not 0 or 1)
- Check: arr[3] >= arr[2] → 4 >= 3? → True
- Return isSorted([1,2,3,4], 3)

Call 2: isSorted([1,2,3,4], 3)
- n = 3 (not 0 or 1)
- Check: arr[2] >= arr[1] → 3 >= 2? → True
- Return isSorted([1,2,3,4], 2)

Call 3: isSorted([1,2,3,4], 2)
- n = 2 (not 0 or 1)
- Check: arr[1] >= arr[0] → 2 >= 1? → True
- Return isSorted([1,2,3,4], 1)

Call 4: isSorted([1,2,3,4], 1)
- n = 1 (base case)
- Return true
```

**Result:** true (array is sorted)

## Dry Run Example 3 - Edge Cases
**Input:** arr = [5], n = 1
```
Call 1: isSorted([5], 1)
- n = 1 (base case)
- Return true
```

**Input:** arr = [], n = 0
```
Call 1: isSorted([], 0)
- n = 0 (base case)
- Return true
```

## Code Structure
- **Method:** `isSorted(int[] arr, int n)`
- **Parameters:**
  - `arr`: input array to check
  - `n`: size of the array (number of elements to consider)
- **Return:** boolean (true if sorted, false otherwise)

## Base Cases
```java
if(n == 0 || n == 1) return true;
```
- **Empty array**: Considered sorted by definition
- **Single element**: Always sorted (nothing to compare)

## Recursive Logic
```java
return arr[n - 1] >= arr[n - 2] && isSorted(arr, n - 1);
```
- **First part**: `arr[n-1] >= arr[n-2]` checks if last two elements are in order
- **Second part**: `isSorted(arr, n-1)` recursively checks the rest
- **AND operation**: Both conditions must be true

## Why Check Backwards?
Checking from end to beginning allows us to:
1. **Reduce problem size** naturally (n becomes n-1)
2. **Use same array** without creating subarrays
3. **Stop early** if any pair is out of order

## Alternative Approaches
1. **Iterative**: Use a loop to check adjacent elements
2. **Forward recursion**: Check from beginning, pass start index
3. **Divide and conquer**: Split array and check both halves

## Time & Space Complexity
- **Time:** O(N) where N is array length (check each adjacent pair once)
- **Space:** O(N) for recursion stack (one call per element)

## Edge Cases Handled
- **Empty array**: Returns true
- **Single element**: Returns true
- **All equal elements**: Returns true (e.g., [2,2,2,2])
- **Strictly increasing**: Returns true (e.g., [1,2,3,4])
- **Mixed order**: Returns false as soon as violation found

## When to Use
- When you want to practice recursion concepts
- When recursive solution is more intuitive than iterative
- When you need to check sorting as part of a larger recursive algorithm 