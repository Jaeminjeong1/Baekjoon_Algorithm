import java.io.*;
import java.util.*;

public class Main {

    static int blueCount;
    static int whiteCount;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop(0, 0, N);
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    private static void loop(int r, int c, int size) {
        int start = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (start != arr[i][j]) {
                    int half = size / 2;
                    loop(r, c, half);
                    loop(r, c + half, half);
                    loop(r + half, c, half);
                    loop(r + half, c + half, half);
                    return;
                }
            }
        }

        if (start == 1) blueCount++;
        else whiteCount++;
    }
}
