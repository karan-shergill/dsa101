# Intervals Pattern

**Mental model:** Intervals = timeline problems. Most solutions reduce to `compare(current, previous)`.

## 1. How to Identify

**Signals in the problem:**
1. Start time/index/value + end time/index/value
2. Range/segment/window on a line

**Common question types:**
1. Minimum rooms/platforms/resources
2. Maximum simultaneous events
3. Can attend all meetings?
4. Merge/remove intervals
5. Insert interval
6. Free slots
7. Conflicts

## 2. How to Approach

1. **Draw the intervals** — reveals overlap and gaps
2. **What matters more?** START time or END time
3. **Sort accordingly** — by start or by end
4. **Sort by END for greedy selection** — finish early → leave room for future intervals
5. **Min-heap** — when you need ACTIVE intervals and care about the earliest ending one (Meeting Rooms II/III, platforms, Smallest Unoccupied Chair)

## 3. Problem → Approach

| Problem asks | Likely approach |
|--------------|-----------------|
| Merge intervals | sort by start |
| Any overlap/conflict | sort by start |
| Min rooms/platforms | min-heap |
| Max concurrent | min-heap |
| Max non-overlapping / min removal | greedy + sort by end |
| Free slots | merge + gaps |

## 4. Sub-patterns

| Sub-pattern | Sort by | Use when |
|-------------|---------|----------|
| Merge overlapping | Start | merge, combine, union, compress |
| Conflict detection | Start | can attend all?, any overlap? |
| Min resources / max concurrent | Start + min-heap on **end** | meeting rooms, platforms |
| Max non-overlapping / min removal / min arrows | **End** | greedy: `curr[0] >= lastEnd` (LC 435, 452) |

## 5. Corner Cases

1. No intervals
2. Single interval
3. Two intervals
4. Non-overlapping intervals
5. One interval fully inside another — e.g. `[1, 10]` contains `[3, 5]`
6. Duplicate intervals — same start and end
7. Touching endpoints — `[1, 3]` and `[3, 5]`: inclusive → overlap (`<=`); exclusive → no overlap (`<`)

## 6. Cheatsheet

#### 6.1 Overlap check — inclusive

```java
// [a, b] and [c, d]
boolean isOverlapping = Math.max(a, c) <= Math.min(b, d);
```

#### 6.2 Overlap check — exclusive

```java
boolean isOverlapping = Math.max(a, c) < Math.min(b, d);
```

#### 6.3 Non-overlapping

```java
boolean isNonOverlapping = b < c || d < a;
```

#### 6.4 Overlapping section

```java
int overlapStart = Math.max(a, c);
int overlapEnd = Math.min(b, d);
if (overlapStart <= overlapEnd) {
    // overlapping: [overlapStart, overlapEnd]
}
```

#### 6.5 Length of overlap

```java
int overlap = Math.max(0, Math.min(b, d) - Math.max(a, c));
```

#### 6.6 Contains interval

```java
// [a, b] fully contains [c, d]
boolean contains = a <= c && d <= b;
```

#### 6.7 Merge two intervals

```java
int mergedStart = Math.min(a, c);
int mergedEnd = Math.max(b, d);
```

#### 6.8 Sort by start / end

```java
Arrays.sort(intervals, (x, y) -> x[0] - y[0]); // merge, overlap
Arrays.sort(intervals, (x, y) -> x[1] - y[1]); // greedy scheduling
```

#### 6.9 Current vs previous

```java
if (curr[0] <= prev[1]) { /* overlap */ }
if (curr[0] > prev[1])  { /* no overlap */ }
prev[1] = Math.max(prev[1], curr[1]); // merge with previous
```

#### 6.10 Min heap — meeting rooms / max concurrent

```java
PriorityQueue<Integer> pq = new PriorityQueue<>(); // earliest end on top

if (!pq.isEmpty() && pq.peek() <= currStart) {
    pq.poll(); // reuse room
}
pq.offer(interval[1]);
```

#### 6.11 Greedy — max non-overlapping intervals (sort by end first)

```java
if (curr[0] >= lastEnd) {
    count++;
    lastEnd = curr[1];
}
```

#### 6.12 Gap between intervals (free time)

```java
int gapStart = prevEnd;
int gapEnd = currStart;
if (gapStart < gapEnd) { /* free slot */ }
```
