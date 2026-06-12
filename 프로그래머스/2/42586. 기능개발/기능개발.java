import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (int) Math.ceil((double) remain / speeds[i]);
            days.offer(day);
        }
        
        List<Integer> result = new ArrayList<>();

        while (!days.isEmpty()) {
            int fromDay = days.poll();
            int count = 1;

            while (!days.isEmpty() && days.peek() <= fromDay) {
                count++;
                days.poll();
            }

            result.add(count);
        }

        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}