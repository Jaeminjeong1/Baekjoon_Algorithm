/*
1. 아이디어
    - BFS
    - (N의 자릿수) x (9) 정도만 탐색하면 된다 -> N - ((N의 자릿수) x (9)) ~ N-1, BUT N이 많이 작으면 1~N-1까지 이므로
    - Max(1, N-(자릿수x9))부터 N-1까지 하면 됨.
    - 각 자릿수의 합은 10으로 계속 나눴을 때의 나머지로 구하면 됨.
    - 자릿수는 10으로 나눌때마다 count값 증가 해도 되고(이건 안 하는게 좋을 듯), "String.valueOf(x).length()" 사용해도됨.
2. 시간 복잡도
    - for문 O(N), while문 중첩이지만, 상수수준?
3. 자료구조
    - 없음.
 */
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = Math.max(1, N - String.valueOf(N).length() * 9);
        int result = 0;
        for (int i = start; i < N; i++) {
            int sum = i;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);

    }
}