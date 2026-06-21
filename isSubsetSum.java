class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] prev = new boolean[sum+1];
        prev[0]=true;
        if(arr[0] <= sum){
            prev[arr[0]] = true;
        }
        for(int idx = 1; idx< arr.length;idx++){
            boolean[] cur = new boolean[sum+1];
            cur[0]=true;
            for(int i = 1;i<=sum;i++){
                boolean taken = prev[i];
                boolean notTaken = prev[i];
                if(arr[idx] <= i){
                    taken =  prev[i  - arr[idx]];
                }
                cur[i] = notTaken || taken;
            }
            prev = cur;
        }
        return prev[sum];
    }
}
