class Solution {
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int len = 0;len<=n;len++){
            dp[0][len] = price[0]*len;
        }
        for(int idx = 1;idx < n;idx++){
            for(int len = 1;len <= n;len++){
                int notTaken = dp[idx-1][len];
                int taken = Integer.MIN_VALUE;
                int rodLength = idx + 1;
                if(len >= rodLength){
                    taken = price[idx] + dp[idx][len-rodLength];
                }
                dp[idx][len] = Math.max(taken,notTaken);
            }
        }
        return dp[n-1][n];
    }
}
