import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Deque<Integer> pq = new ArrayDeque<>();
        
        for(String operation : operations){
            String[] arr = operation.split(" ");
            String alphabet = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if(alphabet.equals("I")){
                pq.offer(num);
                
                //정렬
                List<Integer> list = new ArrayList<>(pq);
                Collections.sort(list);

                pq.clear();
                pq.addAll(list);
            } else if(alphabet.equals("D")){
                if(pq.isEmpty()){
                    continue;
                }
                if(num == 1){
                    pq.pollLast();
                } else if(num == -1){
                    pq.poll();
                }
            }
        }
        
        if(pq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        } else{
            answer[0] = pq.peekLast();
            answer[1] = pq.peek();
        }
        
        return answer;
    }
}