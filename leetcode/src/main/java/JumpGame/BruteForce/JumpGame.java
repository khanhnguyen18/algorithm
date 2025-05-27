package JumpGame.BruteForce;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }


    public static class Solution {

        public boolean canJump(int[] nums) {
            List<Integer> result = new ArrayList<>();
           boolean a=  visit(0, nums, result);
            return false;
        }

        public boolean visit(int index, int[] nums, List<Integer> result) {
            result.add(index);
            if (index == nums.length - 1) {
                return true;
            }

            int step = nums[index];
            for (int i = 1; i <= step; i++) {
                if (index + i < nums.length) {
                    return visit(index + i, nums, result);
                }
            }
            result.remove(result.size() - 1);
            return false;
        }
    }
}
