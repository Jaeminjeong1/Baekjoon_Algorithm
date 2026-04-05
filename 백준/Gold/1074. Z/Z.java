import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = 1 << N; // 2^N
        solve(0, 0, size);

        System.out.println(answer);
    }

    static void solve(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int area = half * half;

        // 1사분면: 왼쪽 위
        if (r < row + half && c < col + half) {
            solve(row, col, half);
        }
        // 2사분면: 오른쪽 위
        else if (r < row + half && c >= col + half) {
            answer += area;
            solve(row, col + half, half);
        }
        // 3사분면: 왼쪽 아래
        else if (r >= row + half && c < col + half) {
            answer += area * 2;
            solve(row + half, col, half);
        }
        // 4사분면: 오른쪽 아래
        else {
            answer += area * 3;
            solve(row + half, col + half, half);
        }
    }
}
