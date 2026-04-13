import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] right; // r-c
    static boolean[] left; // r+c

    static List<int[]> white = new ArrayList<>();
    static List<int[]> black = new ArrayList<>();

    static int maxWhite = 0;
    static int maxBlack = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        right = new boolean[2 * N - 1];
        left = new boolean[2 * N - 1];

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 1) {
                    if ((r + c) % 2 == 0) {
                        white.add(new int[]{r, c});
                    } else {
                        black.add(new int[]{r, c});
                    }
                }
            }
        }

        backtracking(white, 0, 0, true);
        backtracking(black, 0, 0, false);

        System.out.println(maxWhite + maxBlack);
    }

    static void backtracking(List<int[]> list, int start, int count, boolean isWhite) {
        if (isWhite) {
            maxWhite = Math.max(maxWhite, count);
        } else {
            maxBlack = Math.max(maxBlack, count);
        }

        for (int i = start; i < list.size(); i++) {
            int r = list.get(i)[0];
            int c = list.get(i)[1];

            int d1 = r - c + N - 1;
            int d2 = r + c;

            if (!right[d1] && !left[d2]) {
                right[d1] = true;
                left[d2] = true;

                backtracking(list, i + 1, count + 1, isWhite);

                right[d1] = false;
                left[d2] = false;
            }
        }
    }
}
