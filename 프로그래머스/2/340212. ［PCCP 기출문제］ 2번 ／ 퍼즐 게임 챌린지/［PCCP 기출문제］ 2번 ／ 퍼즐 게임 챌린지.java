import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int result = calculation(diffs, times, limit);
        
        return result;
    }
    
    private int calculation(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = Arrays.stream(diffs).max().orElse(0);
        
        while(min <= max) {
            long totTime = 0;
            int mid = (max + min) / 2;
            for(int i=0; i<diffs.length; i++) {
                int diff = diffs[i];
               
                if(diff <= mid) {
                    totTime += times[i];
                }else if(diff > mid){
                    totTime += (diff - mid) * (times[i] + times[i-1]) + times[i];
                }
            }
            if(totTime > limit){
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        return min;
    }
}