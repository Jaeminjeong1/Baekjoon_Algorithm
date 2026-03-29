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

        System.out.println(bfs());
    }

    private static int bfs() {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int n = current[0];
                int m = current[1];

                for (int d = 0; d < 4; d++) {
                    int nr = n + dr[d];
                    int nc = m + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (arr[nr][nc] != 0) continue;

                    arr[nr][nc] = 1;
                    queue.offer(new int[]{nr, nc});
                }
            }

            days++;
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] == 0) {
                    return -1;
                }
            }
        }

        return Math.max(days, 0);
    }

}