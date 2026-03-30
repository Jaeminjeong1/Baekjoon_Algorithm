import java.io.*;
import java.util.*;

public class Main {

    static int M;
    static int N;
    static char[][] arr;
    static boolean[][][] visited;
    static Deque<int[]> queue = new ArrayDeque<>();

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());

    }

    private static int bfs() {
        queue.offer(new int[]{0,0,0,1}); // 시작좌표, 뚫었는지, 거리
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int broken = current[2];
            int distance = current[3];
            
            if (r == N - 1 && c == M - 1) {
                    return distance;
                }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (arr[nr][nc] == '1' && broken == 0 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    queue.offer(new int[]{nr, nc, 1, distance + 1});
                }
                if (arr[nr][nc] == '0' && !visited[nr][nc][broken]) {
                    visited[nr][nc][broken] = true;
                    queue.offer(new int[]{nr, nc, broken, distance + 1});
                }
            }
        }

        return -1;
    }
}
