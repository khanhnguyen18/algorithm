package TwoSum;



import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TwoSumTest {
    TwoSum twoSum = new TwoSum();

    @Test
    void twoSum1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

    @Test
    void twoSum2() {
        int[] nums = new int[]{3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}