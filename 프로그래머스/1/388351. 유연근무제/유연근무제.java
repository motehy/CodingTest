class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i < schedules.length; i++){
            int schedule = schedules[i];
            int count = 0;
            for(int j=0; j < timelogs[i].length; j++){
                int time = timelogs[i][j];
                int dayNum = startday + j;
                count = sumCommute(schedule, time, dayNum, count);
            }
            if(count == 5){
                answer ++;
            }
        }
        return answer;
    }
    
    public int sumCommute(int schedule, int time, int dayNum, int count){
        if(dayNum % 7 == 0 || dayNum % 7 == 6) return count;
        
        int hour = schedule / 100;
        int minute = (schedule % 100) + 10;
        if(minute >= 60){
            minute = minute % 60;
            hour ++;
        }
        if(time <=  (hour*100) + minute) {
            count ++;
        }
        return count;
    }
}