import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        final Map<String, Integer> freq = new HashMap<>();
        int size = 0;

        for (String word : words) {
            size += word.length();
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - size; i++) {
            String sub = s.substring(i, i + size);
            if (find(sub, freq, words)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean find(String sub, Map<String, Integer> freq, String[] words) {
        final Map<String, Integer> cacul = new HashMap<>();

        for (String word : words) {
            int size = word.length();
            for (int j = 0; j <= sub.length() - size; j += size) {
                String str = sub.substring(j, j + size);
                cacul.put(str, cacul.getOrDefault(str, 0) + 1);
            }
        }
        System.out.println(freq);
        System.out.println(cacul);
        return freq.equals(cacul);
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] { "foo", "bar" };
        System.out.println(findSubstring(s, words));

        s = "wordgoodgoodgoodbestword";
        words = new String[] { "word", "good", "best", "word" };
        System.out.println(findSubstring(s, words));

        s = "wordgoodgoodgoodbestword";
        words = new String[] { "word", "good", "best", "good" };
        System.out.println(findSubstring(s, words));

        s = "ababaab";
        words = new String[] { "ab", "ba", "ba" };
        System.out.println(findSubstring(s, words));
    }
}
