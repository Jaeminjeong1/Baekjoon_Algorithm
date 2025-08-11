/*
1. 아이디어
    - BFS
    - 1번째 666, 2번째 1666 ... 187번째 66666, 666이 들어간 수 중 작은 수부터
    - 666부터 1씩 올라가면서, 문자열로 바꿔 '666'이 들어있는지 판단(contains())하고, 들어있으면 종말의 수로 판단.
2. 시간 복잡도
    - O(N * logN) -> N은 '666'부터 하나씩 찾는것, logN은 '666'있는지 확인하는것, 자릿수에 비례하기 때문에 logN. 
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 필요없음.
 */
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int chaosNum = 666;

        int count = 1;
        int temp = 666;
        while (true) {
            temp++;
            if (String.valueOf(temp).contains("666")) {
                chaosNum = temp;
                count++;
            }
            if (count == N) break;
        }

        System.out.println(chaosNum);
    }
}