import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] board = new int[R][C];
        List<Integer> purifier = new ArrayList<>();
        
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == -1) purifier.add(r);
            }
        }
        for (int i = 0; i < t; i++) {
            spread(board);
            operatePurifier(board, purifier.get(0), purifier.get(1));
        }

        calculateTotalAmount(board);
    }

    public static void spread(int[][] board) {
        int[][] tempBoard = new int[R][C];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == -1) {
                    tempBoard[r][c] = -1;
                } else if (board[r][c] > 0) {
                    int currentAmount = board[r][c];
                    int dividedAmount = currentAmount / 5;
                    int count = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && board[nr][nc] != -1) {
                            tempBoard[nr][nc] += dividedAmount;
                            count++;
                        }
                    }

                    tempBoard[r][c] += board[r][c] - (dividedAmount * count);

                }

            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }



    public static void operatePurifier(int[][] board, int topR, int bottomR) {

        // 위쪽 방향
        for (int r = topR - 1; r > 0; r--) {
            board[r][0] = board[r - 1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            board[0][c] = board[0][c + 1];
        }

        for (int r = 0; r < topR; r++) {
            board[r][C - 1] = board[r + 1][C - 1];
        }

        for (int c = C - 1; c > 1; c--) {
            board[topR][c] = board[topR][c - 1];
        }

        board[topR][1] = 0;

        // 아래쪽 방향
        for (int r = bottomR + 1; r < R - 1; r++) {
            board[r][0] = board[r + 1][0];
        }

        for (int c = 0; c < C - 1; c++) {
            board[R - 1][c] = board[R - 1][c + 1];
        }

        for (int r = R - 1; r > bottomR; r--) {
            board[r][C - 1] = board[r - 1][C - 1];
        }

        for (int c = C - 1; c > 1; c--) {
            board[bottomR][c] = board[bottomR][c - 1];
        }

        board[bottomR][1] = 0;
    }

    private static void calculateTotalAmount(int[][] board) {
        int totalAmount = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == -1) continue;
                totalAmount += board[r][c];
            }
        }

        System.out.println(totalAmount);
    }
}