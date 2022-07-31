import java.util.*;

class Solution {
    Queue<Location> bombQue = new LinkedList<>();
    int[] xDir = {0, 1, 1, 0};
    int[] yDir = {0, 0, 1, 1};
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        //스트링 배열 char로 변경
        char[][] charBoard = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                charBoard[i][j] = board[j].charAt(i);
            }
        }
        
        while(checkingBoard(m, n, charBoard)){
            while(bombQue.size() > 0){
                Location l = bombQue.poll();
                for(int k = 0; k < 4; k++){
                    int nx = l.x + xDir[k];
                    int ny = l.y + yDir[k];
                    if(charBoard[nx][ny] != '.'){
                        answer++;
                        charBoard[nx][ny] = '.';
                    }
                }
            }
            organizeBoard(m, n, charBoard);
        }
        
        
        return answer;
    }
    
    public void organizeBoard(int m, int n, char[][] board){
        //String[m] temp = new String[];
        
        for(int i = 0; i < n; i++){
            List<Character> temp = new ArrayList<>(); 
            for(int j = m-1; j >= 0; j--){
                if(board[i][j] != '.'){
                    temp.add(board[i][j]);
                }
            }
            while(temp.size() < m){
                temp.add('.');
            }
            Collections.reverse(temp);
            for(int j = 0; j < m; j++){
                board[i][j] = temp.get(j);
            }
        }
    }
    
    //할거 남았으면 true, 없으면 false;
    public boolean checkingBoard(int m, int n, char[][] board){
        boolean result = false;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                char target = board[i][j];
                if(target == '.'){
                    continue;
                }
                Location loca1 = new Location(i+1, j+1);
                Location loca2 = new Location(i+1, j);
                Location loca3 = new Location(i, j+1);
                if(loca1.x < n && loca2.x < n && loca3.x < n
                   && loca1.y < m && loca2.y < m && loca3.y < m){
                    if(target == board[loca1.x][loca1.y] 
                       && target == board[loca2.x][loca2.y] 
                       && target == board[loca3.x][loca3.y] ){
                        bombQue.add(new Location(i, j));
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}

class Location{
    int x;
    int y;
    
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

