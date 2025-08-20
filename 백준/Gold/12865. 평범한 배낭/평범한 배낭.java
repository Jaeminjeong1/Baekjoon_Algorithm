/*
1. 아이디어
    - DP
    - W[i], V[i]로 weight, value 값 같은 인덱스로 저장함.
    - dp[w] = V -> 현재 고려한 무게가 W일때 최고 가치.
2. 시간 복잡도
    - O(N * K)
    - 1초에 처리할 수 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - N, K, W, V 값 저장 int[]
    - 점화식 저장할 int[]
 */
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N];
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int w = W[i], v = V[i];

            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        
        System.out.println(dp[K]);
    }
}