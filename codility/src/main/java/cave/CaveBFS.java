package cave;

import java.util.LinkedList;
import java.util.Queue;

public class CaveBFS {
  private static final char EMPTY = '.';
  // Don't have up
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}/*, {-1, 0}*/}; // right, down, left, up



  public int solution(String[] B) {
    if (B == null || B.length == 0 || B[0].isEmpty()) return -1;

    int height = B.length;
    int width = B[0].length();
    char[][] map = new char[height][width];

    // Convert board to 2D char array
    for (int i = 0; i < height; i++) {
      map[i] = B[i].toCharArray();
    }

    // Check if start or end is blocked
    if (map[0][0] != EMPTY || map[height - 1][width - 1] != EMPTY) return -1;

    // Use BFS to find shortest path
    return findLongestPath(map);
  }

  private enum DirectionEnum {
    STAND(-1),
    RIGHT(0),
    DOWN(1),
    LEFT(2);

    private final int value;

    DirectionEnum(int value) {
      this.value = value;
    }
  }
  private int findLongestPath(char[][] map) {
    int height = map.length;
    int width = map[0].length;
    Queue<int[]> queue = new LinkedList<>();

    // Start from top-left [x, y, length]
    queue.offer(new int[]{0, 0, 1, DirectionEnum.STAND.value});

    int maxLength = -1;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int length = current[2];
      int prevDirection = current[3];

      // Reached destination
      if (x == height - 1 && y == width - 1) {
        maxLength = Math.max(maxLength, length);
        continue;
      }

      // Try all four directions
      for (int i = 0; i < DIRECTIONS.length; i++) {
        int[] dir = DIRECTIONS[i];
        int newX = x + dir[0];
        int newY = y + dir[1];

        if (isValid(map, newX, newY) && prevDirection != i) {
          queue.offer(new int[]{newX, newY, length + 1, i});
        }
      }
    }

    return maxLength;
  }

  private boolean isValid(char[][] map, int x, int y) {
    return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] == EMPTY;
  }
}
