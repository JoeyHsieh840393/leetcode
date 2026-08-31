import java.util.ArrayList;
import java.util.List;

public class Q17 {
    public static List<String> letterCombinations(String digits) {
        char[][] numbers = new char[8][];

        numbers[0] = "abc".toCharArray();
        numbers[1] = "def".toCharArray();
        numbers[2] = "ghi".toCharArray();
        numbers[3] = "jkl".toCharArray();
        numbers[4] = "mno".toCharArray();
        numbers[5] = "pqrs".toCharArray();
        numbers[6] = "tuv".toCharArray();
        numbers[7] = "wxyz".toCharArray();

        char[] arrDigits = digits.toCharArray();

        List<String> result = new ArrayList<>();

        helper(numbers, arrDigits, 0, new StringBuilder(), result);

        return result;
    }

    private static void helper(char[][] numbers, char[] arrDigits, int k, StringBuilder collect,
            List<String> result) {
        if (k == arrDigits.length) {
            result.add(collect.toString());
            return;
        }
        int num = arrDigits[k] - '0' - 2;
        for (char number : numbers[num]) {
            collect.append(number);
            helper(numbers, arrDigits, k + 1, collect, result);
            collect.deleteCharAt(collect.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
