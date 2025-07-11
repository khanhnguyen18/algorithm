# Maximum trailing zero

- You are given a matrix A consisting of **N rows and M columns**. 
- Each field of the matrix contains a **positive integer**.
- You want to find a path consisting of neighboring fields. Two fields are neighboring if they share a common side. 
- The path can start and end on any field and can turn left or right at most once.
- The product of a path is an integer obtained by multiplying all the integers on the path. Find such a path whose product contains the maximum possible number of trailing zeros.
Write a function
```java
class Solution { 
  public int solution(int[][] A); 
}
```
## Example
1. Given the following matrix (N=3, M=3):
  
   ![img_4.png](../images/black_bell_5.png)
- the function should return 5. 
- You can obtain five trailing zeros by taking the product of numbers 10, 10, 100 and 10 (100,000).

2. Given the following matrix (N=3, M=4):

![img_5.png](../images/black_bell_6.png)

- the function should return 4. You can obtain four trailing zeros by taking the product of numbers 6, 25, 4, 10, 15 and 5 (450,000).

3. Given the following matrix (N=4, M=4):

![img_6.png](../images/black_bell_7.png)
- the function should return 2. You can obtain two trailing zeros by taking the product of numbers 15, 12 and 10 (1800).
4. Given the following matrix (N=4, M=4):

![img_7.png](../images/black_bell_8.png)

the function should return 13.

Write an efficient algorithm for the following assumptions:
* N and M are integers within the range [1..400);
* each element of matrix A is an integer within the range [1..1,000,000,000].

## Analysis
- [MaximumTrailingZeroNDK.java](../../java/blackbelt/MaximumTrailingZeroNDK.java)
```shell
 idea '/Users/P836088/project/algorithm/codility/src/main/java/blackbelt/MaximumTrailingZeroNDK.java'
```

1. Number 10 equal 2x5
   1. We could count number 2's and number 5
2. Only turn 1 time in left of right or not turn
3. Find Max in 3 way
   1. Row (0 Turn)
   2. Column (0 Turn)
   3. Corner
      1. 