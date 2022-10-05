class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int s = 0, e = arr.length - 1;
        int mid = (s + e) / 2;
        int ans = -1;
        while (s < e) {
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
                ans = mid + 1;
            } else {
                e = mid;
                ans = mid;
            }

            mid = (s + e) / 2;
        }
        return ans;
    }
}
