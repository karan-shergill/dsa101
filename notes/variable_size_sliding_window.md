# Variable Size Sliding Window

## When to think of Sliding Window?

Ask these questions:

```
Is it a contiguous
subarray / substring?
        │
        ▼
Can left pointer only
move forward?
        │
        ▼
Can removing elements
restore validity?
        │
        ▼
YES → Sliding Window
```

---

# Core Idea

```
Expand Window
      ↓
Window becomes Invalid
      ↓
Shrink until Valid
      ↓
Update Answer
```

---

# Universal Template

```java
for (; right < n;) {

    // 1. Add
    add(nums[right]);
    right++;

    // 2. Shrink
    while (windowInvalid()) {
        remove(nums[left]);
        left++;
    }

    // 3. Compute
    updateAnswer();
}
```

Only these four things change:

- add()
- remove()
- windowInvalid()
- updateAnswer()

---

# How to Solve Any Problem

### Step 1

What information should my window maintain?

Examples

- sum
- product
- frequency map
- distinct count
- zero count
- max frequency
- min/max deque

---

### Step 2

When is my window invalid?

Examples

```
sum > target
```

```
distinct > K
```

```
cost > budget
```

```
product >= K
```

```
max-min > limit
```

---

### Step 3

How do I restore validity?

Undo exactly what `left` contributed.

```
remove(nums[left]);
left++;
```

---

### Step 4

When should I compute?

This decides the problem type.

---

# Window Types

## Longest Window

```
Shrink until valid

↓

Compute after shrinking
```

```
maxLen = max(maxLen, right-left);
```

---

## Minimum Window

```
Window becomes valid

↓

Compute

↓

Shrink further
```

```
while(valid){
    update();
    shrink();
}
```

---

## Count Windows

Every valid window ending at `right`
creates multiple answers.

```
count += right-left;
```

---

# Exactly K Trick

Sliding Window naturally solves

```
At Most K
```

Convert

```
Exactly(K) = AtMost(K) - AtMost(K-1)
```

---

# At Least Trick

Sliding Window cannot directly shrink
most "At Least" problems.

Convert

```
AtLeast(K) = Total - AtMost(K-1)
```

---

# Common Constraints

| Constraint | Window State |
|------------|--------------|
| At Most K Distinct | HashMap |
| No Duplicates | HashMap |
| Sum | Running Sum |
| Product | Running Product |
| Budget | Running Cost |
| Flip/Delete K | Bad Count |
| Character Replace | Max Frequency |
| Max-Min <= Limit | Monotonic Deque |

---

# Complexity

Every element

- enters once
- leaves once

```
Time  : O(N)
Space : O(Window State)
```

---

# Interview Checklist

✅ Is the answer contiguous?

✅ What does my window maintain?

✅ What makes it invalid?

✅ How do I shrink?

✅ Longest / Minimum / Count?

✅ At Most / Exactly / At Least?
