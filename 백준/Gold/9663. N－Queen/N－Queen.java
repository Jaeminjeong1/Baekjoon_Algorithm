import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] col, left, right;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        col = new boolean[N + 1];
        left = new boolean[2 * N - 1];
        right = new boolean[2 * N - 1];

        backtracking(0);

        System.out.println(count);
    }

    static void backtracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
                int d1 = depth - i + N - 1;
                int d2 = depth + i;
            if (!col[i] && !left[d1] && !right[d2]) {
                col[i] = true;
                left[d1] = true;
                right[d2] = true;

                backtracking(depth + 1);

                col[i] = false;
                left[d1] = false;
                right[d2] = false;
            }
            }
        }
}