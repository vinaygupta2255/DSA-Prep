class Solution {
    
    //using recursion
    public int fib1(int n) {
        //base case
        if(n<=1){
            return n;
        }
        
        return fib(n-1) + fib(n-2);   
    }
    
    
    //solve it using DP
    public int fib(int n) {
          int[] dp = new int[n+1];
            for(int i = 0; i<=n ;i++){
                dp[i] = -1;
               }
          return solve(n, dp);  
    }
    
      public int solve(int n, int[] dp) {
        //base case
        if(n<=1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
          dp[n] = solve(n-1, dp) + solve(n-2, dp);
          return dp[n];
    }
    
  
     
}