package boardgamechecker;

import java.awt.*;

public class BoarGameCheckerImprove1 {
  // Improve 1:
  /*
  Here are the key improvements I made to the code:

  1. Simplified data structure: Changed from Character[][] to char[][] for better performance and memory usage.

  2. Removed unnecessary SolutionContext class: The recursive function now directly returns the maximum length instead of using a context object.

  3. Improved board initialization: Combined the character assignment and starting point detection in a single loop.

  Consolidated movement logic: Created a single canJump method that handles both directions (up-left and up-right) by checking if there's an obstacle to jump over.

  Better recursion structure: The search function now returns the maximum length directly instead of using a mutable context object.

  Removed debugging code: Eliminated the printArray method that was only used for debugging.

  Improved readability: Added more descriptive variable names and comments.

  Fixed logic issue: The original code used an else if between checking up-left and up-right, which meant it would never try both directions from the same position. The refactored version checks both directions.
  */


  // Game board constants
  private static final char EMPTY = '.';
  private static final char STARTING_POINT = 'O';
  private static final char OBSTACLE = 'X';

  public int solution(String[] board) {
    int height = board.length;
    int width = board[0].length();
    char[][] map = new char[height][width];
    Point starting = null;

    // Convert board to 2D char array
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        char cell = board[i].charAt(j);
        map[i][j] = cell;
        if (cell == STARTING_POINT) {
          starting = new Point(i, j);
        }
      }
    }

    return search(map, starting, 0);
  }

  private int search(char[][] map, Point current, int currentLen) {
    int maxLength = currentLen;

    // Check if we can move up-left
    Point upLeft = new Point(current.x - 2, current.y - 2);
    if (canJump(map, current, upLeft)) {
      maxLength = Math.max(maxLength, search(map, upLeft, currentLen + 1));
    }

    // Check if we can move up-right
    Point upRight = new Point(current.x - 2, current.y + 2);
    if (canJump(map, current, upRight)) {
      maxLength = Math.max(maxLength, search(map, upRight, currentLen + 1));
    }

    return maxLength;
  }

  private boolean canJump(char[][] map, Point from, Point to) {
    // Check if destination is in bounds
    if (!isInbound(to.x, to.y, map.length, map[0].length)) {
      return false;
    }

    // Check if destination is empty
    if (map[to.x][to.y] != EMPTY) {
      return false;
    }

    // Calculate the middle position (the obstacle to jump over)
    int midX = (from.x + to.x) / 2;
    int midY = (from.y + to.y) / 2;

    // Check if there's an obstacle to jump over
    return isInbound(midX, midY, map.length, map[0].length) &&
        map[midX][midY] == OBSTACLE;
  }

  private boolean isInbound(int x, int y, int height, int width) {
    return x >= 0 && x < height && y >= 0 && y < width;
  }

}
