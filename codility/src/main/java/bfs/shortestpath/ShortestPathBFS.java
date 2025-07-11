package bfs.shortestpath;

import java.util.*;

public class ShortestPathBFS {

  // Find shortest path from source to target in an unweighted graph
  public List<Integer> findShortestPath(List<List<Integer>> graph, int source, int target) {
    int n = graph.size();
    boolean[] visited = new boolean[n];
    int[] parent = new int[n];
    Arrays.fill(parent, -1);

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(source);
    visited[source] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      if (node == target) {
        return reconstructPath(parent, source, target);
      }

      for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          parent[neighbor] = node;
          queue.offer(neighbor);
        }
      }
    }

    return new ArrayList<>(); // No path exists
  }

  // Reconstruct the path from source to target using parent array
  private List<Integer> reconstructPath(int[] parent, int source, int target) {
    List<Integer> path = new ArrayList<>();
    for (int at = target; at != -1; at = parent[at]) {
      path.add(at);
    }
    Collections.reverse(path);
    return path;
  }

  // Find shortest path in a grid from (startX, startY) to (endX, endY)
  // 0 represents empty cell, 1 represents obstacle
  public int shortestPathInGrid(int[][] grid, int startR, int startC, int endR, int endC) {
    int rows = grid.length;
    int cols = grid[0].length;

    // Direction vectors for 4-directional movement left, righ, up, down
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, 1, -1};

    boolean[][] visited = new boolean[rows][cols];
    int[][][] parent = new int[rows][cols][2]; // Store parent coordinates
    Queue<int[]> queue = new LinkedList<>();

    queue.offer(new int[]{startR, startC, 0}); // {x, y, distance}
    visited[startR][startC] = true;
    parent[startR][startC] = new int[]{-1, -1}; // Mark start with no parent

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int distance = current[2];

      if (x == endR && y == endC) {
        reconstructPath(parent, startR, startC, endR, endC);
        return distance;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dr[i];
        int ny = y + dc[i];

        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols &&
            grid[nx][ny] == 0 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          parent[nx][ny] = new int[]{x, y}; // Store parent coordinates
          queue.offer(new int[]{nx, ny, distance + 1});
        }
      }
    }

    return -1;
  }

  private List<int[]> reconstructPath(int[][][] parent, int startR, int startC, int endR, int endC) {
    List<int[]> path = new ArrayList<>();
    int[] current = new int[]{endR, endC};

    while (current[0] != -1 && current[1] != -1) {
      path.add(new int[]{current[0], current[1]});
      current = parent[current[0]][current[1]];
    }

    Collections.reverse(path);
    return path;
  }
}