/*
1. 아이디어
    - DFS, BFS 둘다 가능
    - DFS 로 구현함. -> 여러 경우의 수 해보고 max 값인거 찾기 -> 백트래킹 사용해야함.
    - char배열로 알파벳 정보 저장함.
    - 탐색할때 (x,y)의 4방향을 탐색해야하므로 -> dx,dy 설정해놓음
    - DFS에 x,y,count 값 넣고 돌림. -> DFS 할 때마다 count 증가하고 백트래킹 전에 maxCount와 비교하여 최대값구하기
2. 시간 복잡도
    - O(N^2)
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 알파벳 방문 여부 boolean[] -> size(26)
    - 초기 알파벳 정보 저장 char[][]
    - dx, dy 값 int[]
 */
import java.io.*;
import java.util.*;

public class Main {
    static char[][] set; // 알페벳 세팅
    static boolean[] visitedAlphabet; // 방문여부
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C;
    static int maxCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        set = new char[R][C];


        for (int i = 0; i < R; i++) {
            set[i] = br.readLine().toCharArray();
        }

        visitedAlphabet = new boolean[26];

        visitedAlphabet[set[0][0] - 'A'] = true;

        DFS(0, 0, 1); // 문제에서, 말이 (1,1)에서 출발

        System.out.println(maxCount);

    }

    static void DFS(int x, int y, int count) {
        maxCount = Math.max(count, maxCount);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) { // R,C 헷갈림.
                int alphabetIndex = set[nx][ny] - 'A';
                if (!visitedAlphabet[alphabetIndex]) {
                    visitedAlphabet[alphabetIndex] = true;
                    DFS(nx, ny, count + 1);
                    visitedAlphabet[alphabetIndex] = false;
                }
            }
        }

    }
}