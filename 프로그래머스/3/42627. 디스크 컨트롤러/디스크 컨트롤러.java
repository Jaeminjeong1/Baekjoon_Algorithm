import java.util.*;

class Solution {
    
    static class Request{
        int number;
        int requestTime;
        int amount;
        
        Request(int number, int requestTime, int amount){
            this.number = number;
            this.requestTime = requestTime;
            this.amount = amount;
        }
        
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Request> pq = new PriorityQueue<>((s1, s2) ->{
            if(s1.amount != s2.amount){
                return Integer.compare(s1.amount, s2.amount);
            }

            if(s1.requestTime != s2.requestTime){
                return Integer.compare(s1.requestTime, s2.requestTime);
            }

            return Integer.compare(s1.number, s2.number);
        });
        
        
        int time = 0;
        int count = 0;
        int index = 0;
        
        while(count < jobs.length){
            
            // 현재 시간보다 요청시간이 적은 것들을 대기큐에 넣기.
            while(index < jobs.length && jobs[index][0] <= time){
                int[] job = jobs[index];
                pq.offer(new Request(index, job[0], job[1]));
                index++;
            }
            
            if(pq.isEmpty()){
                time = jobs[index][0];
                continue;
            }
            
            Request r = pq.poll();
            
            int startTime = r.requestTime;
            
            time += r.amount;
            
            answer += time - startTime;
            
            count++;
        }
        
        return answer / jobs.length;
    }
}