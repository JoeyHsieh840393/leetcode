public class Q38 {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            compress(sb);
        }

        return sb.toString();
    }

    private static void compress(StringBuilder sb) {
        int end = sb.length();

        char temp = sb.charAt(0);
        int count = 1;

        for (int i = 1; i < end; i++) {
            if (temp == sb.charAt(i)) {
                count++;
            } else {
                sb.append(count).append(temp);
                temp = sb.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(temp);
        sb.delete(0, end);
    }
}

