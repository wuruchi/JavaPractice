// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. 
// Return the sum of the three integers. 
// You may assume that each input would have exactly one solution.
// import java.lang.Math;
import java.lang.*;

public class ThreeSumClosest {
  public static void main(String[] args) {
    int[] nums = new int[] {-1, 2, 1, -4};
    int target = 1;
    Solution sol = new Solution();
    sol.threeSumClosest(nums, target);
  }
}

class Solution {  
  public int threeSumClosest(int[] nums, int target){
    int currentDifference = (int)Math.pow(10, 3);
    int currentSum = 0;
    int n = nums.length;
    // int[] items = new int[]{0, 0, 0};
    // Brute Force
    for (int i = 0; i < n; i++){
      for (int j = i + 1; j < n; j++){
        for (int k = j + 1; k < n; k++){
         int diff = Math.abs(target - (nums[i] + nums[j] + nums[k]));
         if (diff <= currentDifference){
            currentDifference = diff;
            currentSum = nums[i] + nums[j] + nums[k];
            // items = new int[]{nums[i], nums[j], nums[k]};
         }
        }
      }
    }
    // System.out.println("Sum closest to the target " + currentSum);
    // System.out.println("Difference " + currentDifference);
    // System.out.println("Items: " + nums[0] + ", " + nums[1] + ", " + nums[2]);
    return currentSum;
  }
}