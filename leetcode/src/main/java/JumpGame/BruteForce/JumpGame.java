package JumpGame.BruteForce;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4};
        System.out.println(new Solution().canJump(nums));
    }


    public static class Solution {

        public boolean canJump(int[] nums) {
            List<Integer> result = new ArrayList<>();
            return visit(0, nums);
        }

        public boolean visit(int index, int[] nums) {
            System.out.println("Visit " + index + "--------");
            if (index == nums.length - 1) {
                return true;
            }

            int maxLengthCanJump = nums[index];
            System.out.println("--- maxLengthCanJump " + maxLengthCanJump + "--------");
            for (int i = 1; i <= maxLengthCanJump; i++) {
                if (index + i < nums.length) {
                    System.out.println("-----Jump " + i + "--------");
                    if (visit(index + i, nums)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
