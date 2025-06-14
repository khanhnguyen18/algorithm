package cave;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class CaveDFS {
  private static final char EMPTY = '.';
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}}; // Right, Down, Left

  private static class SolutionContext {
    private boolean found = false;
    private int maxLength = -1;
  }

  // DFS solution to find the longest path from top-left to bottom-right
  public int solution(String[] B) {
    int height = B.length;
    int width = B[0].length();
    char[][] map = new char[height][width];
    Point starting = new Point(0, 0);
    SolutionContext context = new SolutionContext();
    Set<String> visited = new HashSet<>();

    // Convert board to 2D char array
    for (int i = 0; i < height; i++) {
      map[i] = B[i].toCharArray();
    }

    // Check if starting point is valid
    if (map[0][0] != EMPTY) {
      return -1;
    }

    // Mark starting point as visited
    visited.add(0 + "," + 0);
    search(map, starting, 1, context, visited);
    
    if (context.found) {
      return context.maxLength;
    }
    return -1;
  }

  private void search(char[][] map, Point current, int currentLen, SolutionContext context, Set<String> visited) {
    // Check if we reached the bottom-right corner
    if (current.x == map.length - 1 && current.y == map[0].length - 1) {
      context.found = true;
      if (context.maxLength < currentLen) {
        context.maxLength = currentLen;
      }
      return;
    }

    // Try all directions: right, down, left
    for (int[] dir : DIRECTIONS) {
      int newX = current.x + dir[0];
      int newY = current.y + dir[1];
      String nextKey = newX + "," + newY;
      
      // Check if we can move to this position and haven't visited it yet
      if (isInbound(newX, newY, map.length, map[0].length) && 
          map[newX][newY] == EMPTY && 
          !visited.contains(nextKey)) {
        
        visited.add(nextKey);
        search(map, new Point(newX, newY), currentLen + 1, context, visited);
        visited.remove(nextKey); // Backtrack
      }
    }
  }

  private boolean isInbound(int x, int y, int height, int width) {
    return x >= 0 && x < height && y >= 0 && y < width;
  }
}
