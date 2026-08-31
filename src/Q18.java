import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        System.out.println(Arrays.toString(nums));

        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            if((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }

            if((long) nums[i] + nums[nums.length-3] + nums[nums.length-2] + nums[nums.length-1] < target) {
                continue;
            }

            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > (i + 1) && nums[j] == nums[j-1]) {
                    continue;
                }

                int k = j + 1, l = nums.length - 1;
            
                if((long) nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    break;
                }

                if((long) nums[i] + nums[j] + nums[nums.length-2] + nums[nums.length-1] < target) {
                    continue;
                }
            
                while(k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    System.out.printf("nums[%d] + nums[%d] + nums[%d] + nums[%d] = %d%n", i, j, k, l, sum);

                    if(sum > target){
                        l--;
                    }else if (sum < target) {
                        k++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k-1]){
                            k++;
                        }

                        while(k < l && nums[l] == nums[l+1]){
                            l--;
                        }
                    }
                }
                
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] nums = new int[] {1, 0, 2, -1, 0, -2, 2};
        //int[] nums = new int[] {2, 2, 0, 0, 0, 0};
        //int[] nums = new int[] {-2, -1, -1, 1, 1, 2, 2};
        int[] nums = new int[] {1000000000, 1000000000, 1000000000, 1000000000};
        System.out.println(fourSum(nums, -294967296));
    }
}
