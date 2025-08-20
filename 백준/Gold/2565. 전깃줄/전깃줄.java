import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] wires = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken()); // A
            wires[i][1] = Integer.parseInt(st.nextToken()); // B
        }
        // 1) A 쪽 번호 기준으로 오름차순 정렬
        Arrays.sort(wires, Comparator.comparingInt(a -> a[0]));

        // 2) 정렬된 순서에 대응하는 B 번호들만 뽑아서 LIS
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = wires[i][1];
        }

        // 3) dp[i] = B[i]를 끝으로 하는 증가수열의 최대 길이
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int lis = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (B[j] < B[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            lis = Math.max(lis, dp[i]);
        }

        // 4) 없애야 할 전깃줄 수
        System.out.println(N - lis);
    }
}