import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // 감소하지 않은 값들의 인덱스를 담는다.
        // stack에 있는 것들은 들어온 순서대로, 감소되지 않는게 보장됨.
        // -> stack[1]이 stack[0]보다 작지 않다는 것이 보장됨.
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            int price = prices[i];
            
            while(!stack.isEmpty() && prices[stack.peek()] > price){
                
                int outIndex = stack.pop();
                answer[outIndex] = i - outIndex;
            }
                
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - index - 1;
        }
        
        
        return answer;
    }
}