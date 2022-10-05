class Solution {
    
    
  //Space optimization solution with DP
  // T.C - O(n), S.C - O(1)
    public int climbStairs1(int n) {

       if(n == 1){
           return 1;
       }
       int prev1 = 2;
       int prev2 = 1;
    
        for(int i =3;i<=n;i++){
            int curr = prev1 + prev2;
            // pointer switch for next iteration
            prev2 = prev1;
            prev1 = curr;
         }
        return prev1;
    }
    
  //DP solution
   public int climbStairs(int n) {

       if(n == 1){
           return 1;
       }
       int[] dp = new int[n+1];
       dp[1] = 1;
       dp[2] = 2;
       
        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
         }
        return dp[n];
    }
    
	//Recursion+Memoization solution
    public int climbStairs2(int n) {
       int[] dp = new int[n+1];
         for(int i =0;i<=n;i++){
            dp[i] = -1;
         }
        return solve(n, dp);
    }
    
   int solve(int n, int[] dp){
     
       //base cases
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        
       if(dp[n] !=-1)
           return dp[n];
       
        dp[n] = solve(n-1, dp) + solve(n-2, dp);
        return dp[n];
    }

    
}