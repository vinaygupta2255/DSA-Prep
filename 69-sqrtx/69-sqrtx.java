class Solution {

    public int mySqrt(int n) {
        long s = 0;
        long e = n;
        long mid = 0;
        long ans = -1;
        
        while (s <= e) {
            mid = s + (e - s) / 2;
            long square = mid * mid;

            if (square == n) 
                return (int) mid;

            if (square < n) {
                ans = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (int) ans;
    }
}
