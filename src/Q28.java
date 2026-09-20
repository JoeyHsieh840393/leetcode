public class Q28 {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        int haystackSize = haystack.length(), needleSize = needle.length();

        for (int i = 0; i <= haystackSize - needleSize; i++) {
            String str = haystack.substring(i, i + needle.length());
            if (str.equals(needle)) {
                return i;
            }
        }

        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(j + i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr2("csadbutsad", "sad"));
        System.out.println(strStr2("abcleetcode", "leet"));
        // System.out.println(strStr("abc", "c"));
    }
}
