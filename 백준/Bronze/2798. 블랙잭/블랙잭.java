/*
1. 아이디어
    - BFS
    - N개 중에서 3개의 합이 M보다 작거나 같은 수에서 최댓값.
    - 배열에 모든 카드 넣어 세팅한다.
    - 방법 1. for반복문으로 i, j(i+1), k(j+1)로 설정 -> M보다 작거나 같은 수 중 가장 큰 수 출력.
    - 방법 2. 배열을 정렬하고, 첫번째 카드 고정한 후 left(i+1), right(N-1) 두가지 포인터로 훑는다. left는 커지고, right는 작아지고
2. 시간 복잡도
    - 배열에 넣기 O(N), for문 3중이므로 O(N^3)
3. 자료구조
    - 카드 세팅 배열 int[]
 */
import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }


        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int temp = card[i] + card[j] + card[k];
                    
                    if (temp <= M && temp > result) result = temp;
                    
                    if (result == M) {
                        System.out.println(M);
                        return;
                    }
                }
            }
        }
        System.out.println(result);
    }
}