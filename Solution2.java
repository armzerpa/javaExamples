import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: if the current string length is 2 * max, we've created a valid combination
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Add an open parenthesis if we haven't used all open parentheses
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }

        // Add a close parenthesis if it's valid (fewer close than open)
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}