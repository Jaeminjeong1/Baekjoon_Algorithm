import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            if(arr[i - 1] != temp){
                list.add(temp);
            }
        }

        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}