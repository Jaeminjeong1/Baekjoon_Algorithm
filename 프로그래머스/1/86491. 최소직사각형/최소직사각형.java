import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int x = 0;
        int y = 0;
        
        for(int[] size : sizes){
            if(size[0] > size[1]){
                x = Math.max(x, size[0]);
                y = Math.max(y, size[1]);   
            } else{
                x = Math.max(x, size[1]);
                y = Math.max(y, size[0]);
            }
        }
        
        answer = (x * y);
        return answer;
    }
}