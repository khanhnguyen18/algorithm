package blackbelt;

public class MaximumTrailingZero {
    
    public int solution(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        
        // Count factors of 2 and 5 for each cell
        int[][] twos = new int[N][M];
        int[][] fives = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                twos[i][j] = countFactor(A[i][j], 2);
                fives[i][j] = countFactor(A[i][j], 5);
            }
        }
        
        int maxZeros = 0;
        
        // Try horizontal paths
        maxZeros = Math.max(maxZeros, findHorizontalPaths(twos, fives));
        
        // Try vertical paths  
        maxZeros = Math.max(maxZeros, findVerticalPaths(twos, fives));
        
        // Try L-shaped paths
        maxZeros = Math.max(maxZeros, findLShapedPaths(twos, fives));
        
        return maxZeros;
    }
    
    private int countFactor(int num, int factor) {
        int count = 0;
        while (num % factor == 0) {
            count++;
            num /= factor;
        }
        return count;
    }
    
    private int findHorizontalPaths(int[][] twos, int[][] fives) {
        int N = twos.length;
        int M = twos[0].length;
        int maxZeros = 0;
        
        for (int row = 0; row < N; row++) {
            for (int start = 0; start < M; start++) {
                int sum2 = 0, sum5 = 0;
                for (int end = start; end < M; end++) {
                    sum2 += twos[row][end];
                    sum5 += fives[row][end];
                    maxZeros = Math.max(maxZeros, Math.min(sum2, sum5));
                }
            }
        }
        
        return maxZeros;
    }
    
    private int findVerticalPaths(int[][] twos, int[][] fives) {
        int N = twos.length;
        int M = twos[0].length;
        int maxZeros = 0;
        
        for (int col = 0; col < M; col++) {
            for (int start = 0; start < N; start++) {
                int sum2 = 0, sum5 = 0;
                for (int end = start; end < N; end++) {
                    sum2 += twos[end][col];
                    sum5 += fives[end][col];
                    maxZeros = Math.max(maxZeros, Math.min(sum2, sum5));
                }
            }
        }
        
        return maxZeros;
    }
    
    private int findLShapedPaths(int[][] twos, int[][] fives) {
        int N = twos.length;
        int M = twos[0].length;
        int maxZeros = 0;
        
        // Try all corner positions
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                maxZeros = Math.max(maxZeros, findLFromCorner(twos, fives, r, c));
            }
        }
        
        return maxZeros;
    }
    
    private int findLFromCorner(int[][] twos, int[][] fives, int r, int c) {
        int N = twos.length;
        int M = twos[0].length;
        int maxZeros = 0;
        
        // Try 4 L-shape directions from corner (r,c)
        int[][] dirs = {{0,1,1,0}, {0,1,-1,0}, {0,-1,1,0}, {0,-1,-1,0}};
        
        for (int[] dir : dirs) {
            int dr1 = dir[0], dc1 = dir[1], dr2 = dir[2], dc2 = dir[3];
            
            for (int len1 = 0; len1 < Math.max(N,M); len1++) {
                int r1 = r + dr1 * len1;
                int c1 = c + dc1 * len1;
                if (r1 < 0 || r1 >= N || c1 < 0 || c1 >= M) break;
                
                for (int len2 = 0; len2 < Math.max(N,M); len2++) {
                    int r2 = r + dr2 * len2;
                    int c2 = c + dc2 * len2;
                    if (r2 < 0 || r2 >= N || c2 < 0 || c2 >= M) break;
                    
                    if (len1 == 0 && len2 == 0) continue;
                    
                    int sum2 = calculateLSum(twos, r, c, r1, c1, r2, c2);
                    int sum5 = calculateLSum(fives, r, c, r1, c1, r2, c2);
                    
                    maxZeros = Math.max(maxZeros, Math.min(sum2, sum5));
                }
            }
        }
        
        return maxZeros;
    }
    
    private int calculateLSum(int[][] arr, int r, int c, int r1, int c1, int r2, int c2) {
        int sum = arr[r][c];
        
        // Add horizontal segment
        int minC = Math.min(c, c1);
        int maxC = Math.max(c, c1);
        for (int col = minC; col <= maxC; col++) {
            if (col != c) sum += arr[r][col];
        }
        
        // Add vertical segment
        int minR = Math.min(r, r2);
        int maxR = Math.max(r, r2);
        for (int row = minR; row <= maxR; row++) {
            if (row != r) sum += arr[row][c];
        }
        
        return sum;
    }
}