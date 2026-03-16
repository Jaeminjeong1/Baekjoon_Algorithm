import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] board;

    static int[][][] shapes = {
            // 1. 긴 막대기
            {{0,0}, {0,1}, {0,2}, {0,3}},
            {{0,0}, {1,0}, {2,0}, {3,0}},

            // 2. 정사각형
            {{0,0}, {0,1}, {1,0}, {1,1}},

            // 3. L자 모양
            {{0,0}, {1,0}, {2,0}, {2,1}},
            {{0,1}, {1,1}, {2,0}, {2,1}},
            {{0,0}, {0,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {1,1}, {2,1}},
            {{0,0}, {1,0}, {0,1}, {0,2}},
            {{0,0}, {0,1}, {0,2}, {1,2}},
            {{1,0}, {1,1}, {1,2}, {0,2}},
            {{0,0}, {1,0}, {1,1}, {1,2}},

            // 4. 번개 모양
            {{1,0}, {1,1}, {0,1}, {0,2}},
            {{0,0}, {0,1}, {1,1}, {1,2}},
            {{0,0}, {1,0}, {1,1}, {2,1}},
            {{0,1}, {1,1}, {1,0}, {2,0}},

            // 5.
            {{0,0}, {0,1}, {0,2}, {1,1}}, // ㅜ
            {{1,0}, {1,1}, {1,2}, {0,1}}, // ㅗ
            {{0,0}, {1,0}, {2,0}, {1,1}}, // ㅏ
            {{0,1}, {1,1}, {2,1}, {1,0}}  // ㅓ
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }


        int maxNum = calculateMaxNum();

        System.out.println(maxNum);
    }

    private static int calculateMaxNum() {
        int maxNum = 0;
        
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                for (int i = 0; i < 19; i++) {
                    int sum = 0;
                    boolean isValid = true;

                    for (int j = 0; j < 4; j++) {
                        int nr = r + shapes[i][j][0];
                        int nc = c + shapes[i][j][1];

                        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                            isValid = false;
                            break;
                        }
                        sum += board[nr][nc];
                    }

                    if (isValid) {
                        maxNum = Math.max(maxNum, sum);
                    }
                }

            }
        }
        return maxNum;
    }
}
