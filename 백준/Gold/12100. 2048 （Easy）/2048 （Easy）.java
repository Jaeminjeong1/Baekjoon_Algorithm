import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] initBoard;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        initBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                initBoard[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(answer, initBoard[i][j]);
            }
        }

        backtracking(0, initBoard);

        System.out.println(answer);

    }

    public static void backtracking(int depth, int[][] board) {
        if (depth == 5) {
            answer = Math.max(answer, maxTile(board));
            return;
        }

        for (int dir = 0; dir < 4; dir++) { // 0:UP, 1:DOWN, 2:RIGHT, 3:LEFT
            int[][] next = move(board, dir);
            if (!equalBoard(board, next)) {
                backtracking(depth + 1, next);
            } else {
                // 변화가 없으면 굳이 더 내려가지 않음(가지치기)
            }
        }

        answer = Math.max(answer, maxTile(board));
    }

    // 블럭 움직임, (위, 아래, 오른쪽, 왼쪽) 방향 나누기, 압축(0제거) -> 결합(같은 수 합치기) -> 0채우기
    private static int[][] move(int[][] board, int dir) {
        int[][] copy = copy(board);

        if (dir == 0) { //UP
            for (int col = 0; col < N; col++) {
                int[] line = new int[N];
                for (int row = 0; row < N; row++) line[row] = copy[row][col];
                int[] moved = mergeLine(line);
                for (int row = 0; row < N; row++) copy[row][col] = moved[row];
            }
        } else if (dir == 1) { // DOWN
            for (int col = 0; col < N; col++) {
                int[] line = new int[N];
                for (int row = 0; row < N; row++) line[row] = copy[N - 1 - row][col];
                int[] moved = mergeLine(line);
                for (int row = 0; row < N; row++) copy[N - 1 - row][col] = moved[row];
            }
        } else if (dir == 2) { //RIGHT
            for (int row = 0; row < N; row++) {
                int[] line = new int[N];
                for (int col = 0; col < N; col++) line[col] = copy[row][N - 1 - col];
                int[] moved = mergeLine(line);
                for (int col = 0; col < N; col++) copy[row][N - 1 - col] = moved[col];
            }
        } else if (dir == 3) {
            for (int row = 0; row < N; row++) {
                int[] line = new int[N];
                for (int col = 0; col < N; col++) line[col] = copy[row][col];
                int[] moved = mergeLine(line);
                for (int col = 0; col < N; col++) copy[row][col] = moved[col];
            }
        }

        return copy;
    }

    // 한 줄을 "앞으로" 미는 기준으로 처리 (0 제거 → 합치기(1회) → 0 채우기)
    private static int[] mergeLine(int[] line) {
        int[] filtered = new int[N];
        int idx = 0;
        for (int i : line) if (i != 0) filtered[idx++] = i;

        int[] merged = new int[N];
        int w = 0;
        for (int i = 0; i < idx; i++) {
            if (i + 1 < idx && filtered[i] == filtered[i + 1]) {
                merged[w++] = filtered[i] * 2;
                i++;
            } else {
                merged[w++] = filtered[i];
            }
        }

        while (w < N) merged[w++] = 0;
        return merged;
    }

    private static int maxTile(int[][] board) {
        int num = 0;
        for (int[] row : board) {
            for (int i : row) {
                num = Math.max(num, i);
            }
        }

        return num;
    }

    private static boolean equalBoard(int[][] board, int[][] next) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != next[i][j]) return false;
            }
        }
        return true;
    }

    private static int[][] copy (int[][] board) {
        int[][] copy = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }
}