package boardgamechecker;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;
public class BoardGameChecker {

  private class SolutionContext {
    private int maxLength;

    public int getMaxLength() {
      return maxLength;
    }

    public void setMaxLength(int maxLength) {
      this.maxLength = maxLength;
    }
  }

  // Game board constants
  private static final char EMPTY = '.';
  private static final char STARTING_POINT = 'O';
  private static final char OBSTACLE = 'X';

  public int solution(String[] A) {
    int width = A[0].length();
    int height = A.length;
    Point starting = new Point();


    // Convert A to 2 dimension array
    Character[][] map = new Character[height][width];
    for (int i = 0; i < A.length; i++) {
      for (int j = 0; j < A[0].length(); j++) {
        if (A[i].charAt(j) == STARTING_POINT) {
          starting = new Point(i, j);
          map[i][j] = A[i].charAt(j);
          continue;
        }
        map[i][j] = A[i].charAt(j);
      }
    }
    printArray(map);

    SolutionContext result = new SolutionContext();
    search(map, starting, 0, result);

    return result.getMaxLength();
  }

  public void search(Character[][] map, Point currentPoint, int currentLen, SolutionContext result) {
    if (currentLen > result.getMaxLength()) {
      result.setMaxLength(currentLen);
    }
    if (canGoUpLeft(map, currentPoint)) {
      search(map, new Point(currentPoint.x - 2, currentPoint.y - 2), currentLen + 1, result);
    } else if (canGoUpRight(map, currentPoint)) {
      search(map, new Point(currentPoint.x - 2, currentPoint.y + 2), currentLen + 1, result);
    }
  }
  private boolean isInbound(int x, int y, int height, int width) {
    return x >= 0 && x < height && y >= 0 && y < width;
  }
  private boolean canGoUpLeft(Character[][] map, Point currentPoint) {
    Point upLeft = new Point(currentPoint.x - 1, currentPoint.y - 1);
    Point upLeftLeft = new Point(currentPoint.x - 2, currentPoint.y - 2);
    if (!isInbound(upLeft.x, upLeft.y, map.length, map[0].length) || !isInbound(upLeftLeft.x, upLeftLeft.y, map.length, map[0].length))
      return false;
    return Objects.equals(map[upLeft.x][upLeft.y], 'X') && Objects.equals(map[upLeftLeft.x][upLeftLeft.y], '.');
  }

  private boolean canGoUpRight(Character[][] map, Point currentPoint) {
    Point upRight = new Point(currentPoint.x - 1, currentPoint.y + 1);
    Point upRightRight = new Point(currentPoint.x - 2, currentPoint.y + 2);
    if (!isInbound(upRight.x, upRight.y, map.length, map[0].length) || !isInbound(upRightRight.x, upRightRight.y, map.length, map[0].length))
      return false;
    return Objects.equals(map[upRight.x][upRight.y], OBSTACLE) && Objects.equals(map[upRightRight.x][upRightRight.y],EMPTY);
  }

  void printArray(Character[][] map) {
    for (Character[] arr : map) {
      System.out.println(Arrays.toString(arr));
    }
  }

}
