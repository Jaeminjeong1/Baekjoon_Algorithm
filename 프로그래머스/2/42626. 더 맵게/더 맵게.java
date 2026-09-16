import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville){
            pq.offer(s);
        }
        
        // 가장 작은 것이 K이상일 때까지 진행
        while(pq.peek() < K){
            // 첫번째, 두번째 꺼냄
            if(pq.size() < 2){
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            
            // 두개 조합해서 새로운거 만듦
            int newThing = first + (second * 2);
            // 만들면 count++
            count++;
            // pq에 새로 만든거 넣는다.
            pq.offer(newThing);
        }
        return count;
    }
}