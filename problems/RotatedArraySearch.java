public class RotatedArraySearch {

    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2 ;
            System.out.println("Left " + left + " Mid " + mid + " Right "+right);
            if(nums[mid] == target){
                return mid;
            }
            // if left half is sorted
            if(nums[left] <= nums[mid]){
                // if target is within the left sorted part
                if(nums[left]<= target && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // if right half is sorted
            else {
                // if target is within the right sorted part
                if(nums[mid]< target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        int target = 2;
        int index = search(arr, target);
        if (index != -1) {
            System.out.println("The index of " + target + " is: " + index);
        } else {
            System.out.println(target + " not found in the array.");
        }
    }
}