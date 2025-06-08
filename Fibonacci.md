# Fibonacci Sequence - Documentation

## Problem
Calculate the nth Fibonacci number using recursion.

## What is Fibonacci Sequence?
The Fibonacci sequence is a series of numbers where:
- **First two numbers**: 0 and 1
- **Every next number**: Sum of the two preceding numbers
- **Sequence**: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...

**Mathematical definition:**
- F(0) = 0
- F(1) = 1  
- F(n) = F(n-1) + F(n-2) for n > 1

## Logic Explanation

### How it Works
The recursive approach directly implements the mathematical definition:

1. **Base cases**: 
   - F(0) = 0
   - F(1) = 1
2. **Recursive case**:
   - F(n) = F(n-1) + F(n-2)
   - Calculate by adding the two previous Fibonacci numbers

### Algorithm Steps
1. If n is 0 or 1, return n (base cases)
2. Otherwise, return fibonacci(n-1) + fibonacci(n-2)
3. Each recursive call breaks down the problem into smaller subproblems
4. Eventually reaches base cases and builds up the result

## Dry Run Example
**Input:** n = 5

```
Call: fibonacci(5)
├── fibonacci(4) + fibonacci(3)
    ├── fibonacci(4)
    │   ├── fibonacci(3) + fibonacci(2)
    │   │   ├── fibonacci(3)
    │   │   │   ├── fibonacci(2) + fibonacci(1)
    │   │   │   │   ├── fibonacci(2)
    │   │   │   │   │   ├── fibonacci(1) + fibonacci(0)
    │   │   │   │   │   │   ├── fibonacci(1) → 1
    │   │   │   │   │   │   └── fibonacci(0) → 0
    │   │   │   │   │   └── 1 + 0 = 1
    │   │   │   │   └── fibonacci(1) → 1
    │   │   │   └── 1 + 1 = 2
    │   │   └── fibonacci(2)
    │   │       ├── fibonacci(1) → 1
    │   │       └── fibonacci(0) → 0
    │   │       └── 1 + 0 = 1
    │   └── 2 + 1 = 3
    └── fibonacci(3)
        ├── fibonacci(2) + fibonacci(1)
        │   ├── fibonacci(2)
        │   │   ├── fibonacci(1) → 1
        │   │   └── fibonacci(0) → 0
        │   │   └── 1 + 0 = 1
        │   └── fibonacci(1) → 1
        └── 1 + 1 = 2
    
Final: 3 + 2 = 5
```

**Step-by-step breakdown:**
```
fibonacci(5)
= fibonacci(4) + fibonacci(3)
= (fibonacci(3) + fibonacci(2)) + (fibonacci(2) + fibonacci(1))
= ((fibonacci(2) + fibonacci(1)) + (fibonacci(1) + fibonacci(0))) + ((fibonacci(1) + fibonacci(0)) + fibonacci(1))
= (((fibonacci(1) + fibonacci(0)) + fibonacci(1)) + (fibonacci(1) + fibonacci(0))) + ((fibonacci(1) + fibonacci(0)) + fibonacci(1))
= (((1 + 0) + 1) + (1 + 0)) + ((1 + 0) + 1)
= ((1 + 1) + 1) + (1 + 1)
= (2 + 1) + 2
= 3 + 2
= 5
```

**Result:** 5

## Fibonacci Sequence Values
| n | F(n) |
|---|------|
| 0 | 0    |
| 1 | 1    |
| 2 | 1    |
| 3 | 2    |
| 4 | 3    |
| 5 | 5    |
| 6 | 8    |
| 7 | 13   |
| 8 | 21   |

## Code Structure
- **Method:** `fibonacci(int n)`
- **Parameter:** `n` - the position in Fibonacci sequence (0-indexed)
- **Return:** the nth Fibonacci number

## Base Cases
```java
if(n == 0 || n == 1) return n;
```
- **F(0) = 0**: First Fibonacci number
- **F(1) = 1**: Second Fibonacci number

## Recursive Case
```java
return fibonacci(n - 1) + fibonacci(n - 2);
```
Each Fibonacci number is the sum of the two preceding ones.

## Problems with This Approach

### 1. Exponential Time Complexity
- **Time:** O(2^n) - very slow for large n
- **Reason**: Many subproblems are calculated multiple times

### 2. Redundant Calculations
For fibonacci(5), fibonacci(3) is calculated twice:
```
fibonacci(5)
├── fibonacci(4)
│   └── fibonacci(3) ← calculated here
└── fibonacci(3) ← calculated again here
```

### 3. Stack Overflow Risk
- Deep recursion for large n values
- Each call adds to the call stack

## Better Approaches

### 1. Memoization (Top-down DP)
```java
// Store calculated values to avoid recalculation
Map<Integer, Integer> memo = new HashMap<>();
```

### 2. Dynamic Programming (Bottom-up)
```java
// Build up from F(0) and F(1)
int[] dp = new int[n+1];
dp[0] = 0; dp[1] = 1;
for(int i = 2; i <= n; i++) {
    dp[i] = dp[i-1] + dp[i-2];
}
```

### 3. Iterative Approach
```java
// Keep track of only last two values
int a = 0, b = 1;
for(int i = 2; i <= n; i++) {
    int temp = a + b;
    a = b; b = temp;
}
```

## Time & Space Complexity
- **Time:** O(2^n) - exponential (very inefficient)
- **Space:** O(n) - recursion stack depth

## When to Use This Approach
- **Educational purposes**: Understanding recursion concepts
- **Small values of n**: When n < 20, performance is acceptable
- **Interview questions**: To demonstrate understanding of recursion
- **NOT for production**: Use optimized approaches for real applications

## Real-world Applications of Fibonacci
- **Nature**: Flower petals, pine cones, spiral shells
- **Art**: Golden ratio approximation
- **Computer Science**: Algorithm analysis, data structures
- **Mathematics**: Number theory, combinatorics 