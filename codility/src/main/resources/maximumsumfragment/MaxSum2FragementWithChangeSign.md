# MaxSum2FragementWithChangeSign

- There is an array A of N integers which may contain positive and negative values. 
- Choose two fragments, one of length K and one of length L, to maximize the sum of the elements that belong to the chosen fragments.
- However, if any individual element belongs to both fragments at the same time, each such element is added to the final sum only once and with a changed sign (i.e., negative values become positive values, and vice versa).
- Write a function:
```java
class Solution { public int solution (intll A, int K, int L); }
```
- Returns the maximum total sum that can be obtained.

**Examples**:
1. For A = [1, 3, -4, 2, -1], K = 3, L = 2, you can choose fragment [1, 3, -4] and fragment [-4, 2]. The third element of A belongs to both fragments, so the
   function should return 1 + 3 + -(-4) + 2 = 10.
2. For A = [-5, -3, -4], K = 1, L = 3, the segment of length L will contain each element of A. Then choosing - 5 as the only element of the other segment will
   change its sign in the final sum. The function should return -2.
3. For A = [1, 1, 1, 1, 1], K = 3, L = 3, the function should return 3. You can choose the first three and the last three values as corresponding fragments.
4. For A = [-2, 1, -4, -5], K = 2, L = 3, the function should return 10. The chosen fragments are [-4, - 5] and [1, -4, -5].
- Assume that:
   - N is an integer within the range [1..50];
   - K and L are integers within the range [1..N];
   - each element of array A is an integer within the range [-500..500].
 - In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.