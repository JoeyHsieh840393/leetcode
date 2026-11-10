import java.util.Arrays;

public class Q34 {
    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                first = mid;
                right = mid - 1;
            }
        }

        if (first == -1) {
            return new int[] { -1, -1 };
        }

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                last = mid;
                left = mid + 1;
            }
        }

        return new int[] { first, last };
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
        // int[] nums = new int[] {};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }
}
