import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int num : arr){
            if(stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            Integer stNum = stack.peek();
            if(stNum != num){
                stack.push(num);
            }
        }

        return stack.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}