import java.io.*;
import java.util.*;

public class Main {

    static int[][] box;
    static int N;
    static int sharkSize = 2;
    static int time;
    static int eatCount;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        box = new int[N][N];

        int r = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 9) {
                    r = i;
                    c = j;
                    box[i][j] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs(r, c);

            if (target == null) {
                break;
            }

            time += target.dist;
            r = target.r;
            c = target.c;

            box[r][c] = 0;
            eatCount++;

            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    private static Fish bfs(int r, int c) {
        boolean[][] visited = new boolean[N][N];
        Queue<Node> queue = new ArrayDeque<>();
        List<Fish> candidates = new ArrayList<>();

        queue.offer(new Node(r, c, 0));
        visited[r][c] = true;

        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.dist > minDist) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (box[nr][nc] > sharkSize) {
                    continue;
                }

                visited[nr][nc] = true;
                int nextDist = cur.dist + 1;

                if (box[nr][nc] != 0 && box[nr][nc] < sharkSize) {
                    candidates.add(new Fish(nr, nc, nextDist));
                    minDist = nextDist;
                }

                queue.offer(new Node(nr, nc, nextDist));
            }
        }

        if (candidates.isEmpty()) {
            return null;
        }

        candidates.sort((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.r != b.r) return a.r - b.r;
            return a.c - b.c;
        });

        return candidates.get(0);
    }

    static class Node {
        int r, c, dist;

        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static class Fish {
        int r, c, dist;

        Fish(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
