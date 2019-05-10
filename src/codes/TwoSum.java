package codes;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                    if (nums[j] + nums[i] == target) { result[0] = j; result[1] = i;}

            }
        }
        return result;
    }

    public static void main(String[] args) {
        int sum [] = {2,7,11,15};
        int target = 9;
        twoSum(sum,target);
        System.out.println(twoSum(sum,target)[0] + " " + twoSum(sum,target)[1]);
    }
}
