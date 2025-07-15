package Strings;

import java.util.Arrays;

/**
 * 238 !!
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * some questions that would be good to ask:
 *
 */
public class productexceptself {
    public static int[] problem(int[] nums) {
        if(nums.length == 0) {
            return nums;
        }
        //System.out.println(Arrays.toString(nums));

        //prefix sum
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }
        //System.out.println(Arrays.toString(prefix));

        //postfix sum
        int[] postfix = new int[nums.length];
        postfix[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            postfix[i] = postfix[i+1] * nums[i];
        }
        //System.out.println(Arrays.toString(postfix));

        int[] ans = new int[nums.length];
        ans[0] = postfix[1];
        for (int i = 1; i< nums.length -1; i++) {
            ans[i] = prefix[i-1] * postfix[i+1];
        }
        ans[nums.length-1] = prefix[nums.length-2];

        //System.out.println(Arrays.toString(ans));
        return ans;
    }

    // Custom test case runner
    public static void main(String[] args) {
        // Test cases
        int[] nums = new int[]{1,2,3,4};
        runTest(nums, new int[]{24,12,8,6});
    }

    static int runNumber = 1;
    // Test runner (throws AssertionError if test fails)
    private static void runTest(int[] param1, int[] expected) {
        if (!Arrays.equals(problem(param1), expected)) {
            throw new AssertionError(String.format("❌ Failed: run %d", runNumber));
        }
        System.out.println("✅ Passed:" + runNumber++);
    }
}