package com.example;

public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mag = magazine.toCharArray();
        char[] ran = ransomNote.toCharArray();

        int[] nums = new int[26];

        for (char m : mag) {
            nums[m - 'a']++;
        }

        for (char r : ran) {
            nums[r - 'a']--;

            if (nums[r - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int ransomNoteLength = ransomNote.length();
        int magazineLength = magazine.length();

        if (ransomNoteLength > magazineLength) {
            return false;
        }

        int[] freq = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            int i = magazine.indexOf(ch, freq[ch - 'a']);

            if (i == -1) {
                return false;
            }

            freq[ch - 'a'] = i + 1;
        }

        return true;
    }
}
