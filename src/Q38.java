import org.w3c.dom.css.Counter;

public class Q38 {
    public static String countAndSay(int n) {
        return null;
    }

    private static StringBuilder helper(int n, StringBuilder sb) {
        if (n == 1) {
            return sb.append("1");
        }

        for (int i = 1; i < n; i++) {
        }

        return null;
    }

    private static StringBuilder compress(StringBuilder sb) {
        int end = sb.length();
        StringBuilder result = new StringBuilder();

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
        return sb;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("1");
        System.out.println(compress(str));
        System.out.println(compress(str));
        System.out.println(compress(str));
    }
}
