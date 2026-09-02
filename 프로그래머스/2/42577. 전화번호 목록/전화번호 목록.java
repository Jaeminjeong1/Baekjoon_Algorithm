import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> set = new HashSet();
        
        Arrays.sort(phone_book, (o1, o2) -> o1.length() - o2.length());
        
        for(String number : phone_book){
            for(int i = phone_book[0].length(); i < number.length(); i++){
                String sliced = number.substring(0,i);
                if(set.contains(sliced)) return false;
            }
            set.add(number);
        }
        return true;
    }
}