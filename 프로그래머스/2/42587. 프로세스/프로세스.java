import java.util.*;

class Solution {
    
    static class Object{
        int index;
        int priority;
        
        Object(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        
        Queue<Object> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new Object(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            
            Object current = queue.poll();
            
            if(current.priority < pq.peek()){
                queue.offer(current);
                continue;
            }
            
            pq.poll();
            count++;
            
            if(current.index == location){
                return count;
            }
            
        }
        
        return count;
    }
}