package subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 46. Permutations
 * https://leetcode.com/problems/permutations/description/
 * 
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {

    /**
     * Backtracking approach to generate all permutations
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        // Base case: if current permutation is complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Try each number that hasn't been used yet
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            
            // Choose
            used[i] = true;
            current.add(nums[i]);
            
            // Explore
            backtrack(nums, current, result, used);
            
            // Unchoose (backtrack)
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
    
    /**
     * BFS approach to generate all permutations
     * Time Complexity: O(n!)
     * Space Complexity: O(n * n!)
     */
    public List<List<Integer>> permuteBFS(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        
        for (int num : nums) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Integer> current = queue.poll();
                
                // Insert the number at every possible position
                for (int j = 0; j <= current.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(current);
                    newPermutation.add(j, num);
                    
                    // If we've used all numbers, add to result
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        queue.offer(newPermutation);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Permutations solution = new Permutations();
        
        // Test case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Backtracking approach:");
        System.out.println(solution.permute(nums1));
        
        System.out.println("BFS approach:");
        System.out.println(solution.permuteBFS(nums1));
        
        // Test case 2
        int[] nums2 = {0, 1};
        System.out.println("Backtracking approach:");
        System.out.println(solution.permute(nums2));
        
        System.out.println("BFS approach:");
        System.out.println(solution.permuteBFS(nums2));
    }
}