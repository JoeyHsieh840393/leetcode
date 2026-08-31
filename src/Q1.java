import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(diff, i);
        }
        return new int[]{};
    }

    public static int[] twoSum2(int[] nums, int target){
        Arrays.sort(nums); 

        int left = 0, right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];

            if(sum == target){
                return new int[]{left, right};
            }else if(sum > target) {
                right--;
            }else {
                left++;
            }
        }
        return new int[]{};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }
}

