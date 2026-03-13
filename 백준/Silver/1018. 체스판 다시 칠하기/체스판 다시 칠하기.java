import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] ches = new char[N][M];
        for (int i = 0; i < N; i++) {
            ches[i] = br.readLine().toCharArray();
        }

        int result = Integer.MAX_VALUE;
        for (int r = 0; r <= N - 8; r++) {
            for (int c = 0; c <= M - 8; c++) {
                result = Math.min(result, countChes(ches, r, c));
            }
        }

        System.out.println(result);
    }

    public static int countChes (char[][] ches, int r, int c) {
        int countW = 0;
        int countB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char actual = ches[r + i][c + j];

                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (actual != expectedW) countW++;
                if (actual != expectedB) countB++;
            }
        }
        return Math.min(countW, countB);
    }
}