// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            int area = ( right - left)*(Math.min(height[left],height[right]));
            max = Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            } else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[]{2,3,10,5,7,8,9}));
    }
}
