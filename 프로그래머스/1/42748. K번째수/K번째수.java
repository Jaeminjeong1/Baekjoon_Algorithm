import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        
        for(int i = 0; i < commands.length; i++){
            int[] command = commands[i];
            int a = command[0];
            int b = command[1];
            int c = command[2];
            
            List<Integer> list = new ArrayList<>();
            for(int j = a - 1; j < b; j++){
                list.add(array[j]);
            }
            
            Collections.sort(list);
            answer[i] = list.get(c - 1);
        }
        return answer;
    }
}