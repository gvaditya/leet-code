import java.util.Arrays;
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    static int[] memo;
    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums,nums.length-1);
    }

    private static int rob(int[] nums, int i){
        if(i<0){
            return 0;
        } else{
            if(memo[i]>=0){
                return memo[i];
            }
            int result = Math.max(rob(nums,i-2)+nums[i],rob(nums,i-1));
            memo[i] = result;
            return result;
        }
    }


    public static int robIterative(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memoization = new int[nums.length + 1];
        memoization[0] = 0;
        memoization[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memoization[i+1] = Math.max(memoization[i], memoization[i-1] + nums[i]);
        }
        return memoization[nums.length];
    }

    public static void main(String[] args){
        System.out.println(robIterative(new int[]{1,2,3,1}));
    }
}
