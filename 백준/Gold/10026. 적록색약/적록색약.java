/*
1. 아이디어
    - DFS, BFS 둘다 가능
    - DFS 로 구현함.
    - char배열로 색상 정보 저장함.
    - 탐색할때 (x,y)의 4방향을 탐색해야하므로 -> dx,dy 설정해놓음
    - DFS에 x,y,color 값 넣고 돌림.
2. 시간 복잡도
    - O(N^2)
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 방문 여부 boolean[]
    - 색상 정보 저장 char[][]
    - dx, dy 값 int[]
 */
import java.io.*;
import java.util.*;

public class Main {
    static char[][] set;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        set = new char[N][N];

        for (int i = 0; i < N; i++) {
            set[i] = br.readLine().toCharArray();
        }

        // 일반인 카운트
        visited = new boolean[N][N];
        int normal = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, set[i][j]);
                    normal++;
                }
            }
        }

        // 색약 카운트
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (set[i][j] == 'G') {
                    set[i][j] = 'R';
                }
            }
        }

        visited = new boolean[N][N];
        int blind = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, set[i][j]);
                    blind++;
                }
            }
        }

        System.out.println(normal + " " + blind);
    }

    static void DFS(int x, int y, char color) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && color == set[nx][ny]) {
                    visited[nx][ny] = true;
                    DFS(nx, ny, color);
                }
            }
        }

    }
}