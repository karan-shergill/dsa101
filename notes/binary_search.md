# Binary Search

- [When to Use Binary Search](#when-to-use-binary-search)
- [Common Problem Patterns](#common-problem-patterns)
- [Tips and Tricks](#tips-and-tricks)
- [Code Cheat Sheet](#code-cheat-sheet)
  - [1. Classic Binary Search](#1-classic-binary-search)
  - [2. Finding the First Occurrence of an Element](#2-finding-the-first-occurrence-of-an-element)
  - [3. Finding the Last Occurrence of an Element](#3-finding-the-last-occurrence-of-an-element)
  - [4. Finding the Minimum in a Rotated Sorted Array](#4-finding-the-minimum-in-a-rotated-sorted-array)
  - [5. Binary Search on Answers (Template)](#5-binary-search-on-answers-template)
  - [6. Square Root Approximation (Binary Search)](#6-square-root-approximation-binary-search)
- [Time Complexity](#time-complexity)
  - [1. Classic Binary Search](#1-classic-binary-search)
  - [2. Binary Search on Answers](#2-binary-search-on-answers)
  - [3. Finding First/Last Occurrence](#3-finding-firstlast-occurrence)
  - [4. Finding Minimum in a Rotated Sorted Array](#4-finding-minimum-in-a-rotated-sorted-array)
  - [5. Square Root Approximation](#5-square-root-approximation)
  - [General Formula for Time Complexity](#general-formula-for-time-complexity)
  - [Key Takeaways](#key-takeaways)
- [Examples of Time Complexity Calculations](#examples-of-time-complexity-calculations)
  - [Example 1: Classic Binary Search](#example-1-classic-binary-search)
  - [Example 2: Capacity To Ship Packages Within D Days (LeetCode 1011)](#example-2-capacity-to-ship-packages-within-d-days-leetcode-1011)
  - [Example 3: Split Array Largest Sum (LeetCode 410)](#example-3-split-array-largest-sum-leetcode-410)
  - [Example 4: Finding First/Last Occurrence](#example-4-finding-firstlast-occurrence)

## When to Use Binary Search

1. **Sorted Data**: Binary search is most commonly used on sorted arrays or lists. If the data is sorted, consider if binary search can be applied.
2. **Search Space Reduction**: If the problem involves searching for a specific value, condition, or optimal solution in a large search space, binary search can help reduce the search space efficiently.
3. **Monotonicity**: If the problem has a monotonic property (i.e., the function or condition you're evaluating increases or decreases consistently), binary search can be applied.
4. **Optimization Problems**: Problems that ask for the minimum or maximum value that satisfies a certain condition (e.g., "find the smallest number that meets the criteria") are often good candidates for binary search.

## Common Problem Patterns

1. **Finding an Element in a Sorted Array**: The classic binary search problem.
2. **Finding the First or Last Occurrence of an Element**: Slight modifications to the classic binary search.
3. **Finding the Minimum or Maximum in a Rotated Sorted Array**: Binary search can be used to find the pivot point.
4. **Searching in a 2D Matrix**: If the matrix is sorted in a specific way, binary search can be applied.
5. **Finding the Square Root or Other Mathematical Functions**: Binary search can be used to approximate values.
6. **Allocation Problems**: Problems like "allocate the minimum number of resources" can often be solved using binary search.

## Tips and Tricks

1. **Initialize Boundaries Correctly**: Ensure that your `low` and `high` pointers are set correctly. For example, if searching in an array, `low` should be 0 and `high` should be `len(array) - 1`.
2. **Mid Calculation**: Use `mid = low + (high - low) / 2` to avoid overflow.
3. **Termination Condition**: The loop should continue as long as `low <= high`. This ensures that you don't miss the element if it's the last one checked.
4. **Update Boundaries**: When updating `low` or `high`, ensure you exclude the `mid` element if it's not the target. For example, `low = mid + 1` or `high = mid - 1`.
5. **Edge Cases**: Always consider edge cases, such as an empty array, a single-element array, or when the target is not in the array.
6. **Debugging**: Print the `low`, `mid`, and `high` values at each step to debug and understand how the search space is being reduced.

## Code Cheat Sheet

### 1. Classic Binary Search

```java
public int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2; // Avoids overflow
        if (arr[mid] == target) {
            return mid; // Target found
        } else if (arr[mid] < target) {
            low = mid + 1; // Search right half
        } else {
            high = mid - 1; // Search left half
        }
    }
    return -1; // Target not found
}
```

### 2. Finding the First Occurrence of an Element

```java
public int findFirstOccurrence(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    int result = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            result = mid; // Store the result and search left for earlier occurrences
            high = mid - 1;
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return result;
}
```

### 3. Finding the Last Occurrence of an Element

```java
public int findLastOccurrence(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    int result = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            result = mid; // Store the result and search right for later occurrences
            low = mid + 1;
        } else if (arr[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return result;
}
```

### 4. Finding the Minimum in a Rotated Sorted Array

```java
public int findMinInRotatedArray(int[] arr) {
    int low = 0, high = arr.length - 1;
    while (low < high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] > arr[high]) {
            low = mid + 1; // Minimum is in the right half
        } else {
            high = mid; // Minimum is in the left half (including mid)
        }
    }
    return arr[low]; // Return the minimum element
}
```

### 5. Binary Search on Answers (Template)

This is used for problems where you need to find the **minimum or maximum value** that satisfies a certain condition. Examples include:

- Finding the smallest/largest valid value.
- Allocation problems (e.g., splitting an array into `k` parts with a maximum sum).

```java
public int binarySearchOnAnswers(int[] arr, int k) {
    int left = 0; // Minimum possible answer
    int right = Arrays.stream(arr).sum(); // Maximum possible answer (or any upper bound)
    int result = -1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (isValid(arr, k, mid)) {
            result = mid; // Store the valid result
            right = mid - 1; // Try to find a smaller valid answer
        } else {
            left = mid + 1; // Search for a larger answer
        }
    }
    return result;
}

// Helper function to check if a given value is valid
private boolean isValid(int[] arr, int k, int mid) {
    // Implement your condition here
    // Example: Check if the array can be split into `k` parts with each part <= mid
    int count = 1, sum = 0;
    for (int num : arr) {
        sum += num;
        if (sum > mid) {
            count++;
            sum = num;
            if (count > k) return false;
        }
    }
    return true;
}
```

### 6. Square Root Approximation (Binary Search)

```java
public int sqrt(int x) {
    if (x < 2) return x; // Edge case
    int left = 1, right = x;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (mid == x / mid) { // Avoid overflow by using division
            return mid; // Exact square root found
        } else if (mid < x / mid) {
            left = mid + 1; // Search right half
        } else {
            right = mid - 1; // Search left half
        }
    }
    return right; // Return the floor value of the square root
}
```

## Time Complexity

### 1. Classic Binary Search

- **Time Complexity**: **O(log n)**
- **Explanation**:
    - In each step, the search space is halved.
    - If the array has `n` elements, the number of steps required to reduce the search space to 1 is `log₂(n)`.
    - For example:
        - If `n = 8`, the search space reduces as: 8 → 4 → 2 → 1 (3 steps = log₂(8)).
        - If `n = 16`, the search space reduces as: 16 → 8 → 4 → 2 → 1 (4 steps = log₂(16)).

### 2. Binary Search on Answers

- **Time Complexity**: **O(log n) × O(validation function)**
- **Explanation**:
    - The binary search itself takes **O(log n)**.
    - However, for each midpoint, you need to validate whether it satisfies the condition using a helper function.
    - The time complexity of the validation function depends on the problem:
        - If the validation function is **O(n)**, the total time complexity becomes **O(n log n)**.
        - If the validation function is **O(1)**, the total time complexity remains **O(log n)**.

### 3. Finding First/Last Occurrence

- **Time Complexity**: **O(log n)**
- **Explanation**:
    - This is a variation of binary search where you continue searching even after finding the target to ensure it's the first or last occurrence.
    - The number of steps remains logarithmic because the search space is still halved in each step.

### 4. Finding Minimum in a Rotated Sorted Array

- **Time Complexity**: **O(log n)**
- **Explanation**:
    - Similar to classic binary search, the search space is halved in each step.
    - The decision to move left or right is based on comparing the middle element with the rightmost element.

### 5. Square Root Approximation

- **Time Complexity**: **O(log n)**
- **Explanation**:
    - The search space is the range of possible square roots (e.g., from 1 to `x`).
    - The search space is halved in each step, leading to a logarithmic time complexity.

### General Formula for Time Complexity

For binary search problems, the time complexity can be generalized as:

```
Time Complexity=O(logn)×Time Complexity of Validation Function
```

- If the validation function is **O(1)**, the total time complexity is **O(log n)**.
- If the validation function is **O(n)**, the total time complexity is **O(n log n)**.

### Key Takeaways

1. Binary search itself has a time complexity of **O(log n)**.
2. If the problem involves a validation function, multiply its time complexity by **O(log n)**.
3. Always analyze the validation function's time complexity separately.
4. Binary search is efficient because it reduces the search space exponentially.

## Examples of Time Complexity Calculations

### Example 1: Classic Binary Search

- Problem: Find the index of a target in a sorted array.
- Time Complexity: **O(log n)**
- Explanation: No validation function is needed; the search space is halved in each step.

### Example 2: Capacity To Ship Packages Within D Days (LeetCode 1011)

- Problem: Find the minimum capacity to ship all packages within `D` days.
- Validation Function: Check if a given capacity can ship all packages within `D` days (requires iterating through the array, so **O(n)**).
- Time Complexity: **O(n log n)**
- Explanation:
    - Binary search takes **O(log n)**.
    - Validation function takes **O(n)**.
    - Total time complexity: **O(n log n)**.

### Example 3: Split Array Largest Sum (LeetCode 410)

- Problem: Split an array into `k` subarrays such that the largest sum of any subarray is minimized.
- Validation Function: Check if the array can be split into `k` subarrays with a maximum sum of `mid` (requires iterating through the array, so **O(n)**).
- Time Complexity: **O(n log n)**
- Explanation:
    - Binary search takes **O(log n)**.
    - Validation function takes **O(n)**.
    - Total time complexity: **O(n log n)**.

### Example 4: Finding First/Last Occurrence

- Problem: Find the first or last occurrence of a target in a sorted array.
- Time Complexity: **O(log n)**
- Explanation: The search space is halved in each step, and no additional validation function is needed.
