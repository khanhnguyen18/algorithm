package bfs.shortestpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFSNdk {

  // Find shortest path from source to target in an unweighted graph
  public List<Integer> findShortestPath(List<List<Integer>> graph, int source, int target) {
    int length = graph.size();

    // First, we need to define a queue to store the nodes to be visited
    // and a boolean array to keep track of visited nodes
    // and a array to save the path
    int[] parent  = new int[length];
    boolean[] visited = new boolean[length];
    Queue<Integer> queue = new LinkedList<>(); // FIFO
    queue.offer(source);

    while (!queue.isEmpty()) {
      int node = queue.poll();

      // Find relation between nodes
      for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.offer(neighbor);
          parent[neighbor] = node;
        }
      }

      // Check if the target node is reached
      if (node == target) {
        return reconstructPath(source, target, parent);
      }
    }
    return  Collections.emptyList();

  }

  private List<Integer> reconstructPath(int source, int target, int[] prevPath) {
    List<Integer> path = new ArrayList<>();
    path.add(target);
    while (target != source) {
      target = prevPath[target];
      path.add(target);
    }
    Collections.reverse(path);
    return path;
  }

}