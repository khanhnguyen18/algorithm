# Breadth First Search for Shortest Path Problems
[ShortestPathBFS.java](../../../java/bfs/shortestpath/ShortestPathBFS.java)
BFS is ideal for finding the shortest path in unweighted graphs because it explores nodes in order of their distance from the source.

## How BFS Finds Shortest Paths

1. BFS visits all nodes at distance 1 from the source, then all nodes at distance 2, and so on
2. The first time BFS reaches a node is guaranteed to be via the shortest path
3. By tracking predecessors, we can reconstruct the shortest path

## Algorithm

```java
// Find shortest path from source to target in an unweighted graph
public List<Integer> shortestPath(List<List<Integer>> graph, int source, int target) {
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
```

## Applications

1. **Grid-based pathfinding**: Finding shortest path in a maze or grid
2. **Network routing**: Finding shortest path in a network
3. **Social networks**: Finding shortest connection between people
4. **Web crawling**: Finding shortest path between web pages

## Example: Shortest Path in a Grid

```java
// Find shortest path in a grid from (startX, startY) to (endX, endY)
// 0 represents empty cell, 1 represents obstacle
public int shortestPathInGrid(int[][] grid, int startX, int startY, int endX, int endY) {
    int rows = grid.length;
    int cols = grid[0].length;
    
    // Direction vectors for 4-directional movement
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    boolean[][] visited = new boolean[rows][cols];
    Queue<int[]> queue = new LinkedList<>();
    
    queue.offer(new int[]{startX, startY, 0}); // {x, y, distance}
    visited[startX][startY] = true;
    
    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int x = current[0];
        int y = current[1];
        int distance = current[2];
        
        if (x == endX && y == endY) {
            return distance;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && 
                grid[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, distance + 1});
            }
        }
    }
    
    return -1; // No path exists
}
```

## Time and Space Complexity

- **Time Complexity**: O(V + E) where V is the number of vertices and E is the number of edges
- **Space Complexity**: O(V) for the queue and visited array

BFS guarantees the shortest path in unweighted graphs but doesn't work for weighted graphs (use Dijkstra's algorithm instead).