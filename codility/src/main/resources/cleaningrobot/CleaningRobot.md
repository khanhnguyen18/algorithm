# Clearning Robo
- There is a cleaning robot which is cleaning a rectangular grid of size N x M, represented by array R consisting of N strings. Rows are numbered from 0 to N−1 (from top to bottom) and columns are numbered from 0 to M−1 (from left to right).
- The robot starts cleaning in the top-left corner, facing rightwards. It moves in a straight line for as long as it can, in other words, while there is an unoccupied grid square ahead of it. When it cannot move forward, it rotates 90 degrees clockwise and tries to move forward
  again until it encounters another obstacle, and so on.
- Dots in the array (".") represent empty squares and "X"s represent occupied squares (ones the robot cannot move through). Each square that the robot occupied at least once is considered clean. The robot moves
  indenitely.

```java

class Solution { public int solution(String[] R); }
```
Given an array R consisting of N strings, each of length M, representing the grid, returns the number of clean squares.


**Examples**:
1. Given A = ["...X..", "....XX", "..X..."], your function should return 6.

![img_5.png](../images/cleaningrobot_5.png)
- The robot starts at (0,0), facing rightwards, and moves to (0,2), where it turns due to the obstacle at (0,3). Then it goes down from (0,2)
  to (1,2), where it changes direction again due to another obstacle. Next it goes left from (1, 2) to (1,0), where it turns once because of
  the grid boundary, then it moves once and turns once more, which makes it stand again at position (0,0) facing rightwards, just as at the
  beginning, which means it will now repeat the loop indefinitely. The total number of cleaned squares is 5.
2. Given A = ["....X..", "X......", ".....X.", "......."], your function should return 15.

![img_6.png](../images/cleaningrobot_6.png)

3. Given A = ["...X.", ".X..X", "X...X", "..X.."], your function should return 9.

![img_7.png](../images/cleaningrobot_7.png)

**Assume that:**
- N and M are integers within the range [1..20];
- top-left cell is empty;

## Hints
- Check if robo go indefinitely. -> Robot go same square with same direction.