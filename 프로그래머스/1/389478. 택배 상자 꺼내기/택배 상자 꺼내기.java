class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = n / w + 1;
        int[][] board = new int[h][w];
        board[0][0] = 1;
        setBoard(board, n, w);
        
        int rw = 0;
        int rh = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == num){
                    rh = i;
                    rw = j;
                    break;
                }
            }
        }
        for(int i=rh; i<h; i++){
            if(board[i][rw] > 0){
                answer ++;
            }
        }
        return answer;
    }
    
    private void setBoard(int[][] board, int n, int w){
        int boardW = 0;
        int boardH = 0;
        for(int i = 2; i <= n; i++){

            int dir = (boardH % 2 == 0) ? 1 : -1;

            boardW += dir;

            if(boardW == w){
                boardH++;
                boardW = w - 1;
            }

            if(boardW < 0){
                boardH++;
                boardW = 0;
            }
            board[boardH][boardW] = i;
        }
    }
}