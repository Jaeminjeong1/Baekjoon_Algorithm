import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] used;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        used = new boolean[N + 1];
        sequence = new int[M];

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(i == M - 1 ? "\n" : " ");
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                sequence[depth] = i;
                backtracking(depth + 1);
                used[i] = false;
            }
        }
    }

}