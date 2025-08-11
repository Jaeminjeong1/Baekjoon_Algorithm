/*
1. 아이디어
    - 브루트포스
    - 봉지가 3,5kg만 있음. N이 주어졌을 때 최소한의 봉지수 구하기.
    - 3,5 활용해서 모든 경우의 수 구하고 최소값 출력, 경우의 수 없으면 -1 출력.
2. 시간 복잡도
    - O(N^2) - 이중 for문
    - O(N) - while문 사용 가능.
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

        int count = 0;
        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N = 0;
            } else {
                N -= 3;
                count++;
            }
        }
        
        count = (N < 0) ? -1 : count;
        System.out.println(count);

    }
}