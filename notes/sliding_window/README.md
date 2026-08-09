# Sliding Window

Sliding Window is used to efficiently process **contiguous subarrays / substrings** by maintaining a moving window instead of recomputing every range.

## Patterns

| Pattern                                            | When to Use                                  | Key Idea                           |
| -------------------------------------------------- | -------------------------------------------- | ---------------------------------- |
| [Fixed Size](./fixed_size_sliding_window.md)       | Window size is fixed or can be derived       | **Remove → Add → Compute**         |
| [Variable Size](./variable_size_sliding_window.md) | Window expands/shrinks based on a constraint | **Expand → Shrink → Compute**      |
| [Count](./count_subarray_in_sliding_window.md)     | Count valid subarrays / substrings           | **Count multiple answers at once** |

## Quick Decision Guide

```text
Contiguous subarray / substring?
            │
            ▼
       Sliding Window
            │
     ┌──────┼──────┐
     ▼      ▼      ▼
   Fixed  Variable  Count
     │      │        │
     │      │        ├── AtMost(K)
     │      │        │     → count valid starts
     │      │        │
     │      │        ├── Exactly(K)
     │      │        │     → AtMost(K) - AtMost(K-1)
     │      │        │
     │      │        └── Good / AtLeast
     │      │              → count valid extensions
     │      │
     │      └── Expand → Shrink → Compute
     │
     └── Remove → Add → Compute
```

## Core Questions

When solving a Sliding Window problem, ask:

1. **Is the answer contiguous?**
2. **Is the window size fixed or variable?**
3. **What state does the window maintain?**
4. **What makes the window invalid?**
5. **How do I restore validity?**
6. **Am I finding Longest, Minimum, or Count?**
7. **For counting: how many answers can I count at once?**

## Mental Models

```text
Fixed:
Remove → Add → Compute

Variable:
Expand → Shrink → Compute

Count AtMost:
Shrink until valid → count valid starts

Count Exactly K:
AtMost(K) - AtMost(K-1)

Count Good / AtLeast:
Become valid → count valid extensions
```

