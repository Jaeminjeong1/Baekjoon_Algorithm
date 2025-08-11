/*
1. 아이디어
    - 백트래킹
    - 백트레킹으로 전체 순회하면서 start팀에 넣고(N/2), 나머지는 link팀이라고 판단.
    - 각각 팀에 N/2씩 넣어졌으면 팀 능력치 계산한 후 두팀 능력치 최소값을 반환.
    - selected[] -> true -> start팀
    - selected[] -> false -> link팀 
2. 시간 복잡도
    -
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 점수판 int[][]
    - 선택되었는지 판단 boolean[]
 */
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0);
        System.out.println(minDiff);

    }

    static void backtracking(int start, int count) {
        if (count == N / 2) {
            calculateNum();
            return;
        }

        for (int i = start; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backtracking(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    private static void calculateNum() {
        int starSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    starSum += arr[i][j] + arr[j][i];
                } else if (!selected[i] && !selected[j]) {
                    linkSum += arr[i][j] + arr[j][i];
                }
            }
        }

        int absNum = Math.abs(starSum - linkSum);
        minDiff = Math.min(absNum, minDiff);
    }
}