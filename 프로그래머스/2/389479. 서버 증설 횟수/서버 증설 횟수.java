class Solution {
    static int answer = 0;
    public int solution(int[] players, int m, int k) {
        int[] server = new int[players.length];
        for(int i=0; i<players.length; i++){
            int player = players[i];
            
            addServer(server, player, i, m, k);
        }
        
        return answer;
    }
    
    public void addServer(int[] server, int player, int idx,int m, int duration){
        // 필요한 서버 증설 수 
        int needServer = player / m;
        
        // 추가 서버 증설 수
        int increment = 0;
        
        //현재 서버 가용 수와 필요한 서버 가용수 비교
        if(server[idx] < needServer){
            increment = needServer - server[idx];
        }
        
        if(needServer * m <= player && player < (needServer + 1) * m){
            for(int i=0; i<duration; i++){
                if(idx + i > server.length - 1) break;
                server[idx + i] += increment;
            }
            answer += increment;
        }
    }
}