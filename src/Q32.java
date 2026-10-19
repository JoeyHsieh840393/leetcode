import java.util.ArrayDeque;
import java.util.Deque;

public class Q32 {
    public static int longestValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        stack.push('0');

        char[] chars = s.toCharArray();

        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return chars.length - (stack.size() - 1);
    }
}
