package JumpGame.Greedy;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }


    public static class Solution {

        public boolean canJump(int[] nums) {
            int goal = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                // if could take step to goal
                if (nums[i] + i >= goal) {
                    goal = i;
                }
            }
            return goal == 0;
        }

    }
}
