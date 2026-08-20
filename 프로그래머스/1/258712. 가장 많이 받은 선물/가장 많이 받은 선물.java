import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] history = new int[friends.length][friends.length];  //선물 주고받은 이력
        int[] giftIndex = new int[friends.length];  //선물 지수 
        
        for(String txt : gifts){
            String[] names = txt.split(" ");
            
            history[indexMap.get(names[0])][indexMap.get(names[1])] ++;
            //준 선물 +1
            giftIndex[indexMap.get(names[0])] ++;
            //받은 선물 -1
            giftIndex[indexMap.get(names[1])] --;
        }
        
        int[] receive = new int[friends.length];
        for(int i=0; i<history.length; i++){
            for(int j=0; j<history[i].length; j++){
                if(i == j || history[i][j] < 0) continue;
                // 선물을 더 많이 준 경우
                if(history[i][j] - history[j][i] > 0){
                    receive[i] ++;
                }
                // 주고 받은 선물이 없거나 동일할 경우
                else if(history[i][j] - history[j][i] == 0){
                    if(giftIndex[i] > giftIndex[j]){
                        receive[i] ++;
                        //중복 처리 방지
                        history[i][j] = -1;
                        history[j][i] = -1;
                    }else if(giftIndex[i] < giftIndex[j]){
                        receive[j] ++;
                        //중복 처리 방지
                        history[i][j] = -1;
                        history[j][i] = -1;
                    }
                }
            }
        }
        
        for (int value : receive) {
            answer = Math.max(answer, value);
        }
        
        return answer;
    }
}