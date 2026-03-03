import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        
        execute(1, new ArrayList<>(), n, q, ans);
        return answer;
    }
    
    private void execute(int start, List<Integer> list, int n, int[][] q, int[] ans){
        if(list.size() == 5){
            comparison(list, q, ans);
            return;
        }
        
        for(int i=start; i<=n; i++){
            list.add(i);
            execute(i+1, list, n, q, ans);
            list.remove(list.size() -1);
        }
    }
    
    private void comparison(List<Integer> list, int[][] q, int[] ans) {
        for(int i=0; i<q.length; i++){
            List<Integer> qList =
                Arrays.stream(q[i])
                      .boxed()
                      .collect(Collectors.toList());

            Set<Integer> setQ = new HashSet<>(qList);

            long count = list.stream()
                    .filter(setQ::contains)
                    .count();
            
            if(count != ans[i]){
                return;
            }
        }
        answer = answer +1;
    }
}