import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
        
        // Index 사용하는 경우 s.charAt(i)로 해당 자리 원소 꺼낼 수 있음.
        
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push("(");
            }
            if(c == ')' && !stack.isEmpty()){
                stack.pop();
            } else if(c == ')'){
                return false;
            }
        }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}