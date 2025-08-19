/*
1. 아이디어
    - BFS
    - N, M 돌면서 배열에 값을 저장하고, 1로 표시된 부분(익은 부분)은 Queue에 저장함.
    - queue가 빌때까지 while문 돌면서 BFS 함.
    - while문 안에서 queue의 값에 대하여 동서남북 값 순회하면서 queue + 1 로 바꿔고, queue에 넣음.
    - while문 끝난 후, 처음부터 순회하면서 0값이 있으면 -1 출력, result값을 최대값으로 저장함.
    - result == 1 -> 0일 이므로 0출력, else -> result 출력.
2. 시간 복잡도
    - O(N * M)
    - 1초에 처리할 수 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - dx, dy 값 int[]
    - 익음여부 저장 int[][]
    - BFS 시작점 저장 Queue<int[]>
    - x, y 좌표 값 int[]
 */
import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];


        Queue<int[]> q = new LinkedList<>(); // 잘익은 토마토 위치 - BFS 시작점.

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = board[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, board[i][j]);
            }
        }

        System.out.println(result == 1 ? 0 : result - 1);
    }
}