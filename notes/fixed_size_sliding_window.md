# Fixed Size Sliding Window Cheat Sheet

## 1. Recognition

### Step 1: Is it contiguous?
- Subarray
- Substring
- Consecutive elements

❌ No → Not Sliding Window

✅ Yes → Continue

---

### Step 2: Is every candidate window the SAME size?

If **Yes** → Fixed Sliding Window

The challenge is discovering **what that size is**.

---

## 2. How to Find the Window Size

| Pattern | Window Size | Example |
|---------|-------------|---------|
| Explicit | `k` | Maximum Sum Subarray |
| Pattern Length | `pattern.length()` | Anagrams, Permutation in String |
| Derived | `count(1s)` | Minimum Swaps to Group 1's |
| Duration | `minutes` | Grumpy Bookstore |
| Complement | `n-k` | Maximum Points from Cards |
| Constraint/Proof | `minSize` | Maximum Occurrences of Substring |

---

## 3. Interview Tricks

### Trick 1 — Ignore the story

Convert

> Customers, Cards, Books, Swaps...

into

> **Find the best contiguous block.**

---

### Trick 2 — Think about what remains

Sometimes it's easier to optimize the **complement**.

```
Max selected
        ↓
Min unselected
```

Examples

- Maximum Points from Cards
- Delete from ends problems

---

### Trick 3 — Ask "What must stay together?"

Examples

- All 1's together
- Pattern characters together
- Technique lasts `minutes`

This often reveals the window size.

---

### Trick 4 — Hidden fixed window

Many interview questions never mention **K**.

Derive it from:

- Number of required elements
- Remaining elements
- Pattern length
- Constraints
- A mathematical observation

---

## 4. Generic Template

```java
// Build first window

// Compute initial answer

while (right < n) {

    // Remove left

    // Add right

    // Compute answer
}
```

**Think:** Remove → Add → Compute

---

## 5. What Usually Changes?

| Maintain | Problems |
|----------|----------|
| Sum | Maximum Sum, Average |
| Frequency Map | Anagrams, Permutation |
| HashSet | Duplicate Within K |
| Queue | First Negative |
| Count | Vowels, Ones, Zeros |
| Custom Metric | Extra Customers, Distinct Count |

---

## 6. Complexity

- Time: **O(n)**
- Space: **Depends on maintained state**

---

## 7. Common Mistakes

- Recomputing every window (`O(n*k)`)
- Missing the hidden window size
- Updating answer before first window is complete
- Forgetting to remove zero-frequency map entries

---

## 8. 20-Second Interview Checklist

- [ ] Is it a contiguous subarray/substring?
- [ ] Am I evaluating every window of the same size?
- [ ] Can I derive the window size?
- [ ] Can I update the answer in O(1) when one element leaves and one enters?
- [ ] Is there an easier "complement" version of the problem?

If **YES**, it's almost certainly a **Fixed Size Sliding Window** problem.
