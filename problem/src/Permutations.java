import java.util.*;

/**
 * https://leetcode.com/problems/permutations
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        backtrack(response, nums, new ArrayList<>());
        return response;
    }

    private static void backtrack(List<List<Integer>> response, int[] nums, List<Integer> current){
        if(current.size() == nums.length){
            response.add(new ArrayList<>(current));
        } else{
            for (int i = 0; i < nums.length; i++) {
                if(current.contains(nums[i])) continue;
                current.add(nums[i]);
                backtrack(response,nums,current);
                current.remove(current.size() -1);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(permute(new int[]{1,2,3}));
    }
}