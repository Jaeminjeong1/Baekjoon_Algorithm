import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        loop(0, 0, N);
        
        System.out.println(sb);
    }

    public static void loop(int r, int c, int size) {
        char start = arr[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (start != arr[i][j]) {
                    int half = size / 2;
                    sb.append("(");
                    loop(r, c, half);
                    loop(r, c + half, half);
                    loop(r + half, c, half);
                    loop(r + half, c + half, half);
                    sb.append(")");
                    return;
                }
            }
        }
        sb.append(start);
    }
}
