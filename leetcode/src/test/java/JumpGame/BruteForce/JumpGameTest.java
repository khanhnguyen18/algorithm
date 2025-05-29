package JumpGame.BruteForce;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {
    JumpGame.Solution solution = new JumpGame.Solution();

    @Test
    public void test1(){
        int[] nums = {3, 2, 1, 0, 4};
        assertFalse(new JumpGame.Solution().canJump(nums));
    }

    @Test
    public void test2(){
        int[] nums = {3, 2, 1, 1, 4};
        assertFalse(new JumpGame.Solution().canJump(nums));
    }

}