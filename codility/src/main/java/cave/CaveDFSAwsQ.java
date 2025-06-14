package cave;

import java.util.HashSet;
import java.util.Set;


public class CaveDFSAwsQ {
  private static final char EMPTY = '.';
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}}; // Right, Down, Left
  
  // DFS solution to find the longest path from top-left to bottom-right
  public int solution(String[] B) {
    int height = B.length;
    int width = B[0].length();
    char[][] map = new char[height][width];
    
    // Convert board to 2D char array
    for (int i = 0; i < height; i++) {
      map[i] = B[i].toCharArray();
    }

    // Check if starting point is valid
    if (map[0][0] != EMPTY) {
      return -1;
    }

    Set<Integer> visited = new HashSet<>();
    visited.add(encodePosition(0, 0, width));
    
    Result result = new Result();
    dfs(map, 0, 0, 1, visited, width, result);
    
    return result.maxLength;
  }
  
  private static class Result {
    private int maxLength = -1;
  }
  
  private void dfs(char[][] map, int row, int col, int length, Set<Integer> visited, int width, Result result) {
    // Check if we reached the bottom-right corner
    if (row == map.length - 1 && col == map[0].length - 1) {
      result.maxLength = Math.max(result.maxLength, length);
      return;
    }

    // Try all directions: right, down, left
    for (int[] dir : DIRECTIONS) {
      int newRow = row + dir[0];
      int newCol = col + dir[1];
      int positionKey = encodePosition(newRow, newCol, width);

      // Check if we can move to this position and haven't visited it yet
      if (isValid(newRow, newCol, map) && !visited.contains(positionKey)) {
        visited.add(positionKey);
        dfs(map, newRow, newCol, length + 1, visited, width, result);
        visited.remove(positionKey); // Backtrack
      }
    }
  }
  
  private boolean isValid(int row, int col, char[][] map) {
    return row >= 0 && row < map.length && col >= 0 && col < map[0].length && map[row][col] == EMPTY;
  }
  
  private int encodePosition(int row, int col, int width) {
    return row * width + col;
  }
}