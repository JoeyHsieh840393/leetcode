import java.util.Arrays;

public class Q16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int closest = nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1];

        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0;

            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                closest = Math.abs(closest - target) > Math.abs(sum - target) ? sum : closest;
                System.out.printf("nums[%d] + nums[%d] + nums[%d] = %d%n", i, j, k, sum);
                
                if(sum == target) {
                    return target;
                }else if(sum > target) {
                    k--;
                }else {
                    j++;
                }
            }           
        }
        return closest;
    }

    public static void main(String[] args) {
        // int[] nums = new int[] {-1, 2, 1, -4};
        // int[] nums = new int[] {0, 0, 0};
        // int[] nums = new int[] {10, 20, 30, 40, 50, 60, 70, 80, 90};
        // int[] nums = new int[] {0, 1, 2};
        // int[] nums = new int[] {7, 8, 9};
        // int[] nums = new int[] {4, 0, 5, -5, 3, 3, 0, -4, -5};
        int[] nums = new int[] {2, 3, 8, 9, 10};
        System.out.println(threeSumClosest(nums, 16));
    }
}
