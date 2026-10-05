import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordSize = words[0].length();
        int wordCount = words.length;
        int n = s.length();

        Map<String, Integer> originalCount = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            originalCount.put(words[i], originalCount.getOrDefault(words[i], 0) + 1);
        }

        for (int offset = 0; offset < wordSize; offset++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int start = offset;
            int count = 0;
            for (int end = offset; end + wordSize <= n; end += wordSize) {
                String currWord = s.substring(end, end + wordSize);

                if (originalCount.containsKey(currWord)) {
                    currentCount.put(currWord, currentCount.getOrDefault(currWord, 0) + 1);
                    count++;

                    while (currentCount.get(currWord) > originalCount.get(currWord)) {
                        String startWord = s.substring(start, start + wordSize);
                        currentCount.put(startWord, currentCount.get(startWord) - 1);
                        start += wordSize;
                        count--;
                    }

                    if (count == wordCount) {
                        ans.add(start);
                    }
                } else {
                    count = 0;
                    start = end + wordSize;
                    currentCount.clear();
                }
            }
            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] { "foo", "bar" };
        System.out.println(findSubstring(s, words));

        s = "wordgoodgoodgoodbestword";
        words = new String[] { "word", "good", "best", "word" };
        System.out.println(findSubstring(s, words));

        //s = "wordgoodgoodgoodbestword";
        //words = new String[] { "word", "good", "best", "good" };
        //System.out.println(findSubstring(s, words));

        //s = "ababaab";
        //words = new String[] { "ab", "ba", "ba" };
        //System.out.println(findSubstring(s, words));
    }
}
