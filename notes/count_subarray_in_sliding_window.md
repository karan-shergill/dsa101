# Count Sliding Window 

## 1. Recognition

Use this pattern when the problem asks:

> **How many valid subarrays / substrings?**

Think:

``` text
COUNT valid windows
      ↓
Can I count AT MOST K?
      ↓
If EXACTLY K:
Exactly(K) = AtMost(K) - AtMost(K-1)
```

------------------------------------------------------------------------

## 2. Core Counting Idea

### A. Count valid starts

If current window `[left ... right]` is valid and **every start from
`left` to `right` works**:

``` java
count += right - left + 1;
```

Common for **At Most K**.

If using the style:

``` java
add(nums[right]);
right++;
```

then:

``` java
count += right - left;
```

------------------------------------------------------------------------

### B. Count valid ends

If `[left ... right]` is already good and **every extension to the right
remains good**:

``` java
count += n - right;
```

Common for **At Least / Good** problems.

------------------------------------------------------------------------

# 3. Pattern 1 --- Exactly K ⭐

``` text
Exactly(K)
    =
AtMost(K) - AtMost(K-1)
```

Why?

``` text
AtMost(K)     → 0, 1, 2, ..., K
AtMost(K-1)   → 0, 1, 2, ..., K-1
                       ─────────
                       leaves K
```

### Typical problems

-   **930** --- Binary Subarrays With Sum
-   **992** --- Subarrays with K Different Integers
-   **1248** --- Count Number of Nice Subarrays
-   **2799** --- Count Complete Subarrays

------------------------------------------------------------------------

# 4. AtMost Template

``` java
private long atMost(int[] nums, int k) {

    int left = 0;
    long count = 0;

    for (int right = 0; right < nums.length; right++) {

        // INCREASE
        add(nums[right]);

        // DECREASE
        while (windowInvalid()) {
            remove(nums[left]);
            left++;
        }

        // COMPUTE
        count += right - left + 1;
    }

    return count;
}
```

Then:

``` java
return atMost(nums, k) - atMost(nums, k - 1);
```

------------------------------------------------------------------------

# 5. Pattern 2 --- Good / At Least K

When:

``` text
window becomes GOOD
        ↓
extending it cannot make it BAD
```

count extensions:

``` java
count += n - right;
```

### Typical problems

-   **1358** --- Number of Substrings Containing All Three Characters
-   **2537** --- Count the Number of Good Subarrays

------------------------------------------------------------------------

# 6. 1358 --- Contains All Three Characters

Condition:

``` text
contains a + b + c
```

Once the window contains all three:

``` text
[left ... right]
[left ... right+1]
[left ... right+2]
...
```

are all valid.

So:

``` java
count += n - right;
```

**Key idea:** valid → all right extensions remain valid.

------------------------------------------------------------------------

# 7. 2537 --- Good Subarrays

Good means:

``` text
number of equal-value pairs >= k
```

### Adding `x`

If `x` has appeared `freq` times:

``` java
pairs += freq;
freq[x]++;
```

Example:

``` text
[1, 1, 1]

add 1 → +0 pairs
add 1 → +1 pair
add 1 → +2 pairs

total = 3
```

### Removing `x`

``` java
freq[x]--;
pairs -= freq[x];
```

The order matters.

### When `pairs >= k`

``` java
answer += n - right;
```

Then shrink.

------------------------------------------------------------------------

# 8. Problem Map

  Problem               Pattern   Main idea
  --------------------- --------- -------------------------
  713 Product \< K      AtMost    `count += right-left+1`
  1358 Contains a,b,c   Good      `count += n-right`
  930 Binary Sum        Exactly   `AtMost(K)-AtMost(K-1)`
  992 K Distinct        Exactly   `AtMost(K)-AtMost(K-1)`
  1248 Nice Subarrays   Exactly   `AtMost(K)-AtMost(K-1)`
  2799 Complete         Exactly   `AtMost(D)-AtMost(D-1)`
  2537 Good Subarrays   Good      maintain pair count

------------------------------------------------------------------------

# 9. How to Think in an Interview

When you see:

``` text
Count subarrays / substrings
```

ask:

``` text
1. Is it contiguous?
        ↓
2. What state does my window maintain?
        ↓
3. Is it asking EXACTLY K?
        ↓
   Try AtMost(K) - AtMost(K-1)
        ↓
4. If window becomes GOOD,
   do extensions remain GOOD?
        ↓
   Try count += n - right
        ↓
5. Otherwise, how many valid
   starting positions exist?
        ↓
   count += right - left + 1
```

------------------------------------------------------------------------

# 10. The One-Line Mental Models

### Exactly K

``` text
Exactly K = AtMost K - AtMost K-1
```

### AtMost K

``` text
Shrink until valid → count all valid starts
```

### Good / At Least

``` text
Become good → count all valid extensions
```

### 2537

``` text
new occurrence of x → + current frequency[x] pairs
```

------------------------------------------------------------------------

## Final Cheat Sheet

``` text
              COUNT SLIDING WINDOW
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
       AtMost       Exactly      Good/AtLeast
          │            │            │
          │      AtMost(K) -        │
          │      AtMost(K-1)        │
          │            │            │
          ▼            ▼            ▼
   count valid     isolate K     count extensions
      starts                         │
          │                          │
          ▼                          ▼
 right-left+1                    n-right
```

**Core question:**

> **Once my window is valid, how many answers can I count at once?**
