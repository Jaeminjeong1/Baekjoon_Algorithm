/*
1. 아이디어
    - 브루트 포스 시간 안 됨 -> 누적합 생각
    - 체스판 입력받고 저장
    - 시작지점(1,1) 색이 W,B인지에 따른 이상적인 체스판 설정
    - W,B 각각 이상적인 체스판과 실제 체스판이 다르면 각 자리수 1, 아니면 0으로 유지 (mW, mB)
    - mW,mB로 2차원 누적합 구해서 sumW,sumB에 저장
    - 각 인덱스 돌면서 W,B 일때 K크기의 체스판 만들 경우 최소값 찾기
2. 시간 복잡도
    - N,M의 이중 for문 -> O(N x M), 5번 -> O(5 x N x M)
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 입력받은 체스판 ches[][] -> char[][]
    - 이상적인 체스판 IW[][], IB[][] -> char[][]
    - 실제와 이상의 차이 담음 mW[][], mB[][] -> int[][]
    - (1,1)부터의 2차원 누적합 담는 sumW[][], sumB[][] -> int[][]
    - 인덱스에 따른 KxK에서의 수정할 개수 pW[][], pB[][] -> int[][]
 */
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] ches = new char[N + 1][M + 1];
        char[][] IW = new char[N + 1][M + 1];
        char[][] IB = new char[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                ches[i][j] = line.charAt(j - 1);
            }

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ((i + j) % 2 == 0) {
                    IW[i][j] = 'W';
                    IB[i][j] = 'B';
                } else {
                    IW[i][j] = 'B';
                    IB[i][j] = 'W';
                }
            }
        }

        // W,B로 시작할 때 실제와 다른 부분 수 담는 배열
        int[][] mW = new int[N + 1][M + 1];
        int[][] mB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                mW[i][j] = (ches[i][j] != IW[i][j]) ? 1 : 0;
                mB[i][j] = (ches[i][j] != IB[i][j]) ? 1 : 0;
            }
        }

        //(0,0)부터의 2차원 누적합 배열
        int[][] sumW = new int[N + 1][M + 1];
        int[][] sumB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sumW[i][j] = sumW[i - 1][j] + sumW[i][j - 1] - sumW[i - 1][j - 1] + mW[i][j];
                sumB[i][j] = sumB[i - 1][j] + sumB[i][j - 1] - sumB[i - 1][j - 1] + mB[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int[][] pW = new int[N + 1][M + 1];
        int[][] pB = new int[N + 1][M + 1];

        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                pW[i][j] = sumW[i + K - 1][j + K - 1] - sumW[i + K - 1][j - 1] - sumW[i - 1][j + K - 1] + sumW[i - 1][j - 1];
                pB[i][j] = sumB[i + K - 1][j + K - 1] - sumB[i + K - 1][j - 1] - sumB[i - 1][j + K - 1] + sumB[i - 1][j - 1];
                int min = Math.min(pW[i][j], pB[i][j]);
                result = Math.min(result, min);
            }
        }

        System.out.println(result);
    }
}