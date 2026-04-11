import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        backtracking(0, 0);

        System.out.println(sb);
    }

    private static void backtracking(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(temp[i]).append(i == M - 1 ? "\n" : " ");
            }
            return;
        }

        int prev = -1;
        for (int i = start; i < N; i++) {
            if ((arr[i] != prev)) {
                temp[depth] = arr[i];
                prev = arr[i];
                backtracking(i, depth + 1);
            }
        }
    }
}
