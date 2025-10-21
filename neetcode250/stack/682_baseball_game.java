// https://leetcode.com/problems/baseball-game/description/

class Solution {
    public int calPoints(String[] operations) {
        List<Integer> score = new LinkedList<>();
        for (String operation: operations) {
            switch(operation) {
                case "+":   
                    if (score.size() < 2) {
                        break;
                    }
                    score.add(score.get(score.size() - 1) + score.get(score.size() - 2));
                    break;

                case "C":
                    if (score.isEmpty()) {
                        break;
                    }
                    score.remove(score.size() - 1);
                    break;

                case "D":
                    if (score.isEmpty()) {
                        break;
                    }
                    score.add(score.get(score.size() - 1) * 2);
                    break;

                default:
                    score.add(Integer.valueOf(operation));
            }
        }

        int sum = 0;
        for (int val : score) {
            sum += val;
        }
        return sum;
    }
}

/*
TC: O(n)
SC: O(n)
*/

/*
Learning:
1. Initially, I considered using a stack, but since operations would require popping and pushing again, I chose a Linked List (LL) instead, where we can access value via index. It's better to think about these aspects from the beginning.
2. Integer.valueOf is used to convert a String to an Integer.
3. Plan for edge cases as early as possible.
*/
