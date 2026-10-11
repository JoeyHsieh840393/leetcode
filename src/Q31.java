import java.util.Arrays;

public class Q31 {
    public static void nextPermutation(int[] nums) {
        int pivot = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int j = nums.length - 1; j > pivot; j--) {
            if (nums[j] > nums[pivot]) {
                swap(nums, j, pivot);
                break;
            }
        }

        reverse(nums, pivot + 1, nums.length - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[] { 1, 3, 5, 4, 2 };
        int[] nums = new int[] { 2, 2, 1 };
        System.out.println(Arrays.toString(nums));
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
