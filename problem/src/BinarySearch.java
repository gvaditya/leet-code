public class BinarySearch {
    static int binarySearch(int[] arr, int l, int r, int x){
        if(r>=l){
            int mid = l + (r-1)/2;
            if(arr[mid] == x){
                return x;
            }
            if(arr[mid] >x){
                return binarySearch(arr,l,mid-1,x);
            } else{
                return binarySearch(arr,mid+1, r,x);
            }
        }
        return -1;
    }
}
