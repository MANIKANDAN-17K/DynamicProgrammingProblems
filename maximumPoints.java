class Solution {
    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return func(n-1,3,mat,dp);
    }
    private int func(int day,int last,int[][] mat,int[][] dp){
        if(dp[day][last] != -1){
            return dp[day][last];
        }
        if(day == 0){
            int maxi = 0;
            for(int i = 0;i<=2;i++){
                if(i != last)
                    maxi = Math.max(maxi,mat[0][i]);
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        int activity = 0;
        for(int i = 0;i<=2;i++){
            if(i != last){
                activity = mat[day][i]+func(day-1,i,mat,dp);
            }
            maxi = Math.max(maxi,activity);
        }
        return dp[day][last] = maxi;
    }
}
