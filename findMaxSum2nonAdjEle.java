class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        int prev2 = 0;
        int prev = arr[0];
        for(int i = 1;i<n;i++){
            int include = arr[i] + prev2;
            int exclude = prev;
            int curr = Math.max(include,exclude);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
