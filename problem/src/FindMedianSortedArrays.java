class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left =0;
        int right =0;
        int m = nums1.length;
        int n= nums2.length;
        boolean isEven = ((m+n)%2)==0;
        int middle = (m+n)/2;
        int prevMiddle = 0;
        for (int i = 0; i < m+n; i++) {
            boolean isMiddle = i== middle;
            boolean isPrevMiddle = i== (middle-1);
            if(left<m && (right>= n || nums1[left]<nums2[right])) {
                if(isMiddle){
                    if(isEven){
                        return (nums1[left] + prevMiddle)/2.0;
                    } else {
                        return nums1[left];
                    }
                }
                if(isPrevMiddle && isEven){
                    prevMiddle = nums1[left];
                }
                left++;
            } else{
                if(isMiddle){
                    if(isEven){
                        return (nums2[right] + prevMiddle)/2.0;
                    } else{
                        return nums2[right];
                    }
                }
                if(isPrevMiddle && isEven){
                    prevMiddle = nums2[right];
                }
                right++;
            }
        }
        return 0.0;
    }

    public static void main(String args[]){
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
    }
}