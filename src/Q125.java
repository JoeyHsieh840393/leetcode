package com.example;

public class Q125 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("a."));
        System.out.println(isPalindrome("1b1"));
    }

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!((leftChar >= 'A' && leftChar <= 'Z') || (leftChar >= 'a' && leftChar <= 'z')
                    || (leftChar >= '0' && leftChar <= '9'))) {
                left++;
                continue;
            } else if ((leftChar >= 'A' && leftChar <= 'Z')) {
                leftChar += 32;
            }

            if (!((rightChar >= 'A' && rightChar <= 'Z') || (rightChar >= 'a' && rightChar <= 'z')
                    || (rightChar >= '0' && rightChar <= '9'))) {
                right--;
                continue;
            } else if ((rightChar >= 'A' && rightChar <= 'Z')) {
                rightChar += 32;
            }

            if (rightChar != leftChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
