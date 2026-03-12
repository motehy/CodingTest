import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;
class Solution {
    static String[][] container = null;
    static int dx[] = {-1, 0, 1, 0}; 
    static int dy[] = {0, 1, 0, -1}; 
    static int sxl = 0;
    static int syl = 0;
    static boolean[][] visited;
    
    public int solution(String[] storage, String[] requests) {
        
        setContainer(storage);
        
        for (String req : requests) {
            String value = String.valueOf(req.charAt(0));
            removeRequest();
            if (req.length() == 1) remove(value);
            else removeAll(value);
        }
        
        int count = 0;
        for (int i=1; i<=sxl; i++) {
            for (int j=1; j<=syl; j++) {
                if (container[i][j].equals("-1")) continue;
                count++;
            }
        }
        
        return count;
    }
    
    private void removeRequest() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[container.length][container[0].length];
        q.add(new int[]{0,0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i=0; i<4; i++) {
                int nx = dx[i] + cur[0];
                int ny = dy[i] + cur[1];
                if (nx < 0 
                    || ny < 0 
                    || nx >= container.length 
                    || ny >= container[0].length
                   ) continue;
                if (visited[nx][ny] || !"-1".equals(container[nx][ny])) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }

    // 크레인 이용
    void removeAll(String value) {
        for (int i=1; i<=sxl; i++) {
            for (int j=1; j<=syl; j++) {
                if (container[i][j].equals(value)) container[i][j] = "-1";
            }
        }
    }
    
    // 지게차
    void remove(String value) {
        for (int i=1; i<=sxl; i++) {
            for (int j=1; j<=syl; j++) {
                if (container[i][j].equals(value)) {
                    if (check(i,j)) container[i][j] = "-1";   
                }
            }
        }
    }
    
    boolean check(int x, int y) {
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) return true;
        }
        return false;
    }

    //컨테이너 데이터 세팅
    private void setContainer(String[] storage){
        sxl = storage.length;
        syl = storage[0].length();
        container = new String[sxl + 2][syl + 2];
        for (int i=0; i<sxl+2; i++) {
            Arrays.fill(container[i],"-1");
        }
        
        for (int i=0; i<sxl; i++) {
            for (int j=0; j<syl; j++) {
                container[i+1][j+1] = String.valueOf(storage[i].charAt(j));
            }
        }
    }
}