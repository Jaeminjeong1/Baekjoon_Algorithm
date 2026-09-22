import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        for(int[] size : sizes){
            x = Math.max(x, Math.max(size[0], size[1]));
            y = Math.max(y, Math.min(size[0], size[1]));
        }
        
        answer = (x * y);
        return answer;
    }
}