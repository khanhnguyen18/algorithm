import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TwoSumSolutionTest {

    private TwoSumSolution solution = new TwoSumSolution();

    @Test
    public void testExample1() {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] expected = {1, 2};
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }

    @Test
    public void testExample3() {

        int[] nums = {3, 3};
        int target = 6;
        int[] expected = {0, 1};
        assertArrayEquals(expected, solution.twoSum(nums, target));
    }
}