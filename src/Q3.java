import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Set<Character> bucket = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < chars.length; right++) {
            if (bucket.contains(chars[right])) {
                while (bucket.contains(chars[right])) {
                    bucket.remove(chars[left]);
                    left++;
                }
                bucket.add(chars[right]);
            } else {
                bucket.add(chars[right]);
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;
        char[] chars = s.toCharArray();

        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right]) && map.get(chars[right]) >= left) {
                left = map.get(chars[right]) + 1;
            }
            map.put(chars[right], right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int[] index = new int[128];
        int left = 0, maxLength = 0;
        char[] arr = s.toCharArray();

        for (int right = 0; right < arr.length; right++) {
            left = Math.max(left, index[arr[right]]);
            index[arr[right]] = right + 1;
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("eea"));
    }
}
