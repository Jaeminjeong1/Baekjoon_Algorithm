import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int count = 0;
        for(int key : map.keySet()){
            count++;
        }
        
        answer = Math.min(count, size);
        
        return answer;
    }
}