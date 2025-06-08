# Generate Parentheses - Documentation

## Problem
Given `n` pairs of parentheses, generate all combinations of well-formed (balanced) parentheses.

## Logic Explanation

### How it Works
The solution uses **backtracking** to build valid parentheses combinations step by step.

**Key Rules:**
1. We can add an opening bracket `(` if we haven't used all `n` opening brackets yet
2. We can add a closing bracket `)` only if it won't make the string invalid (i.e., we have more opening brackets than closing brackets so far)
3. When our string reaches length `2*n`, we have a complete valid combination

### Algorithm Steps
1. Start with an empty string
2. At each step, try adding either `(` or `)`
3. Add `(` if we haven't used all opening brackets
4. Add `)` if it keeps the string balanced (more opening than closing so far)
5. When string length equals `2*n`, add it to results
6. Backtrack by removing the last character and trying other options

## Dry Run Example
**Input:** n = 2 (we need 2 pairs of parentheses)

```
Start: current = "", open = 0, close = 0, max = 2

Step 1: current = ""
- Can add '(' (open < max): current = "(", open = 1, close = 0

Step 2: current = "("
- Can add '(' (open < max): current = "((", open = 2, close = 0
- Can add ')' (close < open): current = "()", open = 1, close = 1

Branch 1: current = "(("
- Cannot add '(' (open = max = 2)
- Can add ')' (close < open): current = "(()", open = 2, close = 1

Step 3: current = "(()"
- Cannot add '(' (open = max = 2)
- Can add ')' (close < open): current = "(())", open = 2, close = 2
- Length = 4 = 2*max ✓ Add "(())" to result

Branch 2: current = "()"
- Can add '(' (open < max): current = "()(", open = 2, close = 1

Step 4: current = "()("
- Cannot add '(' (open = max = 2)
- Can add ')' (close < open): current = "()()", open = 2, close = 2
- Length = 4 = 2*max ✓ Add "()()" to result
```

**Final Result:** `["(())", "()()"]`

## Code Structure
- **Main Method:** `generateParenthesis(int n)` - starts the process and returns results
- **Helper Method:** `helper(...)` - recursive function that builds combinations
- **Parameters:**
  - `result`: list to store all valid combinations
  - `current`: current string being built
  - `open`: count of opening brackets used so far
  - `close`: count of closing brackets used so far
  - `max`: total pairs needed (n)

## Time & Space Complexity
- **Time:** O(4^n / √n) - related to Catalan numbers
- **Space:** O(4^n / √n) for storing results + O(n) for recursion depth 