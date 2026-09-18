import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // a.compare(b)일 때, a < b 일 경우 a가 우선적으로 나옴.
        PriorityQueue<String> pq = new PriorityQueue<>(
            (s1, s2) -> (s2 + s1).compareTo(s1 + s2)
        );
        
        for(int number : numbers){
            pq.offer(String.valueOf(number));
        }
        
        if(pq.peek().equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        
        
        return sb.toString();
    }
}