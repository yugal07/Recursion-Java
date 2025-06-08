# Phone Letters Combination - Documentation

## Problem
Given a string of digits (2-9), return all possible letter combinations that the number could represent, just like on old phone keypads.

## Phone Keypad Mapping
```
2: abc    3: def    4: ghi
5: jkl    6: mno    7: pqrs
8: tuv    9: wxyz
```

## Logic Explanation

### How it Works
The solution uses **backtracking** to generate all possible combinations by:
1. For each digit, look up its corresponding letters
2. Try each letter one by one
3. Move to the next digit and repeat
4. When we've processed all digits, we have a complete combination

### Algorithm Steps
1. Create a mapping array where index represents digit and value represents letters
2. Start with the first digit (index 0)
3. For current digit, get all its possible letters
4. Try each letter:
   - Add it to current combination
   - Recursively process next digit
   - Remove the letter (backtrack) and try next letter
5. When we reach the end of digits string, add combination to results

## Dry Run Example
**Input:** digits = "23"

```
Mappings: [0:"", 1:"", 2:"abc", 3:"def", ...]

Start: index = 0, current = "", digits = "23"

Step 1: index = 0, digit = '2'
- Letters for '2': "abc"
- Try 'a': current = "a", move to index 1
  
  Step 2: index = 1, digit = '3'
  - Letters for '3': "def"
  - Try 'd': current = "ad", index = 2 (end) ✓ Add "ad"
  - Try 'e': current = "ae", index = 2 (end) ✓ Add "ae"  
  - Try 'f': current = "af", index = 2 (end) ✓ Add "af"
  
- Try 'b': current = "b", move to index 1
  
  Step 2: index = 1, digit = '3'
  - Try 'd': current = "bd", index = 2 (end) ✓ Add "bd"
  - Try 'e': current = "be", index = 2 (end) ✓ Add "be"
  - Try 'f': current = "bf", index = 2 (end) ✓ Add "bf"
  
- Try 'c': current = "c", move to index 1
  
  Step 2: index = 1, digit = '3'
  - Try 'd': current = "cd", index = 2 (end) ✓ Add "cd"
  - Try 'e': current = "ce", index = 2 (end) ✓ Add "ce"
  - Try 'f': current = "cf", index = 2 (end) ✓ Add "cf"
```

**Final Result:** `["ad","ae","af","bd","be","bf","cd","ce","cf"]`

## Code Structure
- **Main Method:** `letterCombinations(String digits)` - starts the process
- **Helper Method:** `helper(...)` - recursive function that builds combinations
- **Parameters:**
  - `index`: current position in digits string
  - `mappings`: array mapping digits to letters
  - `digits`: input string of digits
  - `result`: list to store all combinations
  - `current`: current combination being built

## Special Cases
- Empty input: returns empty list
- Single digit: returns all letters for that digit

## Time & Space Complexity
- **Time:** O(3^N × 4^M) where N is digits with 3 letters, M is digits with 4 letters
- **Space:** O(3^N × 4^M) for storing results + O(N) for recursion depth 