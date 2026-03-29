import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int N;
    static int[][] arr;
    static Deque<int[]> queue = new ArrayDeque<>();

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());

                if (arr[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        bfs();
        System.out.println(getAnswer());
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int n = current[0];
            int m = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = n + dr[i];
                int nc = m + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (arr[nr][nc] != 0) {
                    continue;
                }

                arr[nr][nc] = arr[n][m] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }

    private static int getAnswer() {
        int max = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] == 0) {
                    return -1;
                }
                max = Math.max(max, arr[r][c]);
            }
        }

        return max - 1;
    }
}