import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        String answer = "";
        for (String player : participant){
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        for (String c : completion){
            map.put(c, map.get(c) - 1);
        }
        
        for (String key : map.keySet()){
            if(map.get(key) == 1){
                answer = key;
            }
        }
        return answer;
    }
}