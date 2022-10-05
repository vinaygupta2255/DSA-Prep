class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = firstOcc(nums, nums.length, target);
        output[1] = lastOcc(nums, nums.length, target);
        return output;
    }

    int firstOcc(int[] arr, int n, int key) {
        int s = 0, e = n - 1;
        int mid = 0;
        int ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                ans = mid;
                e = mid - 1;
            } else if (key > arr[mid]) { //Right me jao
                s = mid + 1;
            } else if (key < arr[mid]) { //left me jao
                e = mid - 1;
            }
        }

        return ans;
    }

    int lastOcc(int[] arr, int n, int key) {
        int s = 0, e = n - 1;
        int mid = 0;
        int ans = -1;

        while (s <= e) {
            mid = s + (e - s) / 2;
            if (arr[mid] == key) {
                ans = mid;
                s = mid + 1;
            } else if (key > arr[mid]) { //Right me jao
                s = mid + 1;
            } else if (key < arr[mid]) { //left me jao
                e = mid - 1;
            }
        }

        return ans;
    }
}
