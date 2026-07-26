# Fixed Size Sliding Window Cheat Sheet

---

# 1. Recognition Flow

```text
Is it a contiguous subarray/substring?

        No
         │
         ▼
Not a Sliding Window problem

        Yes
         │
         ▼
Am I evaluating every contiguous block of the SAME size?

        Yes
         │
         ▼
Fixed Size Sliding Window

        No
         │
         ▼
Can I derive a fixed window size?

Examples:
- Pattern length
- Total number of 1's
- Duration (minutes)
- n - k
- minSize

        Yes
         │
         ▼
Fixed Size Sliding Window

        No
         │
         ▼
Probably Variable Sliding Window
(or another algorithm)
```

---

# 2. Mental Checklist (30 Seconds)

Before coding, ask yourself:

- [ ] Is this about a **contiguous subarray/substring**?
- [ ] Am I checking **every contiguous block of the same length**?
- [ ] Is the window size:
    - Explicitly given?
    - Hidden but derivable?
    - Pattern length?
    - Complement (`n-k`)?
    - Final block size?
    - Proven from constraints?
- [ ] Can I update the answer in **O(1)** when one element leaves and another enters?

If the answer is **YES**, it's probably a Fixed Size Sliding Window problem.

---

# 3. How to Identify the Window Size

## Pattern 1 — Explicit Window Size

The easiest category.

### Keywords

- Size K
- Length K
- Subarray of size K
- Substring of length K
- Every K elements

### Examples

- Maximum Sum Subarray of Size K
- Maximum Number of Vowels
- Number of Subarrays with Average >= Threshold

Window

```text
window = k
```

---

## Pattern 2 — Pattern Length

The window size comes from another input.

### Examples

Find All Anagrams

```text
window = pattern.length()
```

Permutation in String

```text
window = pattern.length()
```

Reason

The substring must have exactly the same length as the pattern.

---

## Pattern 3 — Derived Window Size

The window size isn't given directly.

Instead ask:

> What must be the size of the final contiguous block?

### Example

### Minimum Swaps to Group All 1's Together

Count total 1's.

```text
window = totalOnes
```

Reason

Eventually all 1's must become one contiguous block.

---

### Grumpy Bookstore Owner

```text
window = minutes
```

Reason

The owner's secret technique lasts exactly `minutes`.

---

## Pattern 4 — Complement Window

Instead of thinking

> What am I selecting?

Think

> What remains after selecting?

### Example

Maximum Points You Can Obtain from Cards

Take

```text
k cards
```

↓

Leave behind

```text
n-k cards
```

The remaining cards are always contiguous.

Therefore

```text
window = n-k
```

Find

```text
Minimum sum window of size n-k
```

Answer

```text
Total Sum - Minimum Window Sum
```

Recognition Rule

Whenever a problem says

- Pick from both ends
- Remove from both ends

Always ask

> What remains?

---

## Pattern 5 — Proof-Based Window

Sometimes the window exists only after proving something.

### Example

Maximum Number of Occurrences of a Substring

Problem

```text
minSize <= substring length <= maxSize
```

Observation

For any substring

```text
frequency(long substring)
<=
frequency(any of its minSize substrings)
```

Therefore

Checking lengths greater than `minSize` is unnecessary.

Window

```text
window = minSize
```

---

# 4. Standard Algorithm

Almost every Fixed Sliding Window problem follows the same pattern.

```java
// Build first window
for (int i = 0; i < k; i++) {
    add(arr[i]);
}

computeAnswer();

for (int right = k; right < n; right++) {

    // Remove
    remove(arr[right - k]);

    // Add
    add(arr[right]);

    // Compute
    computeAnswer();
}
```

---

# 5. Sliding Window Template

```text
Build First Window

↓

Compute Initial Answer

↓

Slide Window

    Remove Left

    Add Right

    Compute Answer

↓

Repeat
```

---

# 6. What Changes Inside the Window?

The sliding logic never changes.

Only the maintained state changes.

| Problem | Maintained State |
|----------|------------------|
| Maximum Sum | Running Sum |
| Average >= Threshold | Running Sum |
| Maximum Vowels | Vowel Count |
| Distinct Subarray | Sum + Frequency Map |
| Duplicate within K | HashSet |
| Find All Anagrams | Frequency Map |
| Permutation in String | Frequency Map |
| Minimum Swaps to Group 1's | Count of 1's |
| Grumpy Bookstore | Extra Satisfied Customers |
| First Negative in Window | Queue of Negative Numbers |

---

# 7. Recognition Tricks

## Trick 1

Ignore the story.

Instead convert it into

```text
Find the best contiguous block.
```

Stories about

- Customers
- Cards
- Swaps
- Books
- Characters

are often distractions.

---

## Trick 2

Look for a hidden window size.

Common hidden windows

- Pattern length
- Total number of 1's
- Minutes
- Remaining elements (`n-k`)
- Minimum allowed length (`minSize`)

---

## Trick 3

Think about what remains.

Sometimes

```text
Maximize selected
```

is easier as

```text
Minimize unselected
```

Example

Maximum Points from Cards

---

## Trick 4

Ask

> What changes when the window moves by one?

Usually

```text
One element leaves.

One element enters.
```

If the answer can be updated in O(1), Sliding Window is a good candidate.

---

# 8. Time Complexity

Building first window

```text
O(k)
```

Sliding

```text
O(n-k)
```

Overall

```text
O(n)
```

Space

Depends on maintained data.

| State | Space |
|--------|-------|
| Running Sum | O(1) |
| HashSet | O(k) |
| HashMap | O(k) |
| Queue | O(k) |

---

# 9. Common Mistakes

❌ Recomputing the whole window every time

```text
O(n × k)
```

---

❌ Updating the answer before the first window is complete

---

❌ Forgetting to remove zero-frequency entries from a HashMap

---

❌ Mixing Variable Sliding Window logic with Fixed Sliding Window

---

❌ Missing the hidden window size

---

# 10. Recognition Table

| Pattern | Window Size | Example |
|----------|-------------|---------|
| Explicit | `k` | Maximum Sum Subarray |
| Pattern Length | `pattern.length()` | Anagrams, Permutation in String |
| Derived | `count(1's)` | Minimum Swaps to Group All 1's Together |
| Duration | `minutes` | Grumpy Bookstore Owner |
| Complement | `n-k` | Maximum Points You Can Obtain from Cards |
| Proof-Based | `minSize` | Maximum Number of Occurrences of a Substring |

---

# 11. My Interview Approach

Whenever I see a new problem, I go through this checklist.

```text
1. Is it asking about a contiguous subarray or substring?

2. Is every candidate answer the same length?

3. If not, can I derive the window length?

4. Can I rewrite the problem as:

   "Find the best contiguous block of length ____"

5. Can I update the window in O(1) by:

   Remove Left
   Add Right
   Compute Answer

If YES, it's almost certainly a Fixed Size Sliding Window problem.
```

---

# 12. Summary

Fixed Size Sliding Window problems usually fall into one of these categories:

| Category | Recognition |
|----------|-------------|
| Explicit Window | Window size is directly given |
| Pattern Length | Window size equals another input (e.g. pattern length) |
| Derived Window | Window size is hidden (e.g. total 1's, minutes) |
| Complement Window | Think about what remains instead of what is selected |
| Proof-Based Window | Need an observation/proof before the window size becomes obvious |

> **The hardest part of Fixed Size Sliding Window is rarely the implementation.**
>
> The real interview challenge is recognising **why a fixed window exists**.
