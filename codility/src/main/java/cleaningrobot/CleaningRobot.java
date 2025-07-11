package cleaningrobot;

import java.util.HashSet;
import java.util.Set;

public class CleaningRobot {

  // Direction vectors: right, down, left, up
  private static final int[] dx = {0, 1, 0, -1};
  private static final int[] dy = {1, 0, -1, 0};

  public int solution(String[] R) {
    int N = R.length;
    int M = R[0].length();

    // Set to track visited cells with direction
    Set<String> visited = new HashSet<>();

    // Set to track cleaned cells
    Set<String> cleaned = new HashSet<>();

    int x = 0, y = 0; // Starting position
    int dir = 0;      // 0: right, 1: down, 2: left, 3: up

    while (true) {
      // Mark current cell as cleaned
      cleaned.add(x + "," + y);

      // Check if we've been in this cell with this direction before
      String state = x + "," + y + "," + dir;
      if (visited.contains(state)) {
        break; // We're in a loop
      }
      visited.add(state);

      // Try to move forward
      int nx = x + dx[dir];
      int ny = y + dy[dir];

      // Check if next position is valid
      if (nx >= 0 && nx < N && ny >= 0 && ny < M && R[nx].charAt(ny) != 'X') {
        // Move forward
        x = nx;
        y = ny;
      } else {
        // Rotate 90 degrees clockwise
        dir = (dir + 1) % 4;
      }
    }

    return cleaned.size();
  }
}