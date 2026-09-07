import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, new StringBuilder(2 * n), result); 
        return result;
    }

    private static void helper(int open, int close, int n, StringBuilder collect, List<String> result) {
        if(collect.length() == 2 * n) {
            result.add(collect.toString());
            return;
        }

        if(open < n) {
            collect.append("(");
            helper(open + 1, close, n, collect, result);
            collect.deleteCharAt(collect.length() - 1);
        }

        if(close < open) {
            collect.append(")");
            helper(open, close + 1, n, collect, result);
            collect.deleteCharAt(collect.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
