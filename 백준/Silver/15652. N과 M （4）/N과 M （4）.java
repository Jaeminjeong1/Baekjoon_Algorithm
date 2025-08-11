import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] sequence;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sequence = new int[M];

        backtracking(1, 0);

        System.out.println(sb);
    }

    static void backtracking(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(i == M - 1 ? "\n" : " ");
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            sequence[depth] = i;
            backtracking(i, depth + 1);
        }
    }

}