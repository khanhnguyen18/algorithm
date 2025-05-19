import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TwoSumSolutionTest {

    private TwoSumSolution twoSumSolution = new TwoSumSolution();

    @Test
    void twoSum() {
        int[] result = new int[5];

        assertEquals(null, twoSumSolution.twoSum(result, 7));
    }
}