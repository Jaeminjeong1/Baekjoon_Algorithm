import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> stack = new Stack<>();
        
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