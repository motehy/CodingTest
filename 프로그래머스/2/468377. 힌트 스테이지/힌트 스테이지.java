class Solution {
    int[][] cost, hint;
    int n;
    long answer = Long.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        this.n = cost.length;
        
        dfs(0, 0, new int[n]);
        
        return (int) answer;
    }
    
    private void dfs(int stage, long totalCost, int[] coupons) {
        totalCost += cost[stage][coupons[stage]];

        if (stage == n - 1) {
            answer = Math.min(answer, totalCost);
            return;
        }

        // 힌트 묶음 미구매
        dfs(stage + 1, totalCost, coupons);

        // 힌트 묶음 구매
        int[] nextCoupons = coupons.clone();
        for (int j = 1; j < hint[stage].length; j++) {
            int targetStage = hint[stage][j] - 1;
            nextCoupons[targetStage] = Math.min(n - 1, nextCoupons[targetStage] + 1);
        }

        dfs(stage + 1, totalCost + hint[stage][0], nextCoupons);
    }
}