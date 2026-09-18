import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        //int[]은 내림차순 정렬이 불가능함.
        // 정렬후 뒤 인덱스부터 사용하거나
        // 오름차순 정렬 후 직접 새로운 배열 만들어야함.
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                return h;
            }
        }
        
        return 0;
    }
}