/*
1. 아이디어
    - BFS
    - 체스판 배열에 담은 후, 체스판의 모든 (r,c)에 대하여 8x8을 고려해봄.
    - (r,c)가 White, Black일 때, 둘다 고려해서 더 작은 수를 출력함.
    - 기대되는 색 구하기 -> (i+j)가 짝수면 시작 색과 같음.
    - 실제와 기대되는 색 다르면 count 증가.
2. 시간 복잡도
    - O((N-7)x(M-7) x 8 x 8) < 120,000
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - char[][] 페스판.
 */
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] ches = new char[N][M];
        // toCharArray()활용해서 판 만들기. 이중 for문 안 써도 됨.
        for (int i = 0; i < N; i++) {
            ches[i] = br.readLine().toCharArray();
        }

        // Math.min 쓰지까 충분히 큰 수로 초기화 해야함.
        int result = Integer.MAX_VALUE;
        for (int r = 0; r <= N - 8; r++) {
            for (int c = 0; c <= M - 8; c++) {
                result = Math.min(result, countChes(ches, r, c));
            }
        }

        System.out.println(result);
    }

    static public int countChes (char[][] ches, int r, int c) {
        int countW = 0;
        int countB = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char actual = ches[r + i][c + j];
                //기대되는 색 구하기 -> (i+j)가 짝수면 시작 색과 같음.
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
                //실제와 기대가 다르면 count증가.
                if (actual != expectedW) countW++;
                if (actual != expectedB) countB++;
            }
        }
        return Math.min(countW, countB);
    }
}