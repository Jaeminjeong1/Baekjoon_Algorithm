/*
1. 아이디어
    - 각 교실을 순회하면서(반복문) 총 감독을 넣고 부족한 부 감독의 수를 구함.
    - 각 교실의 학생 수 - (총감독 감시자수) -> count++ -> 이 값이 양수일 경우 부감독의 수를 구함.
2. 시간 복잡도
    - O(N)
    - 1초에 처리할 수 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - long[] 교실당 학생 수 저장
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long B = Long.parseLong(st.nextToken()); // 총 감독
        long C = Long.parseLong(st.nextToken()); // 부 감독

        long count = 0L;

        for (int i = 0; i < N; i++) {
            long temp = arr[i];
            temp -= B;
            count++;

            if(temp > 0) {
                long res = temp % C;
                long c = temp / C;
                if (res != 0) {
                    count += c + 1;
                } else {
                    count += c;
                }

                // count += (temp + C - 1) / C; -> 이렇게 줄일 수 있음. 올림 나눗셈.
            }
        }

        System.out.println(count);
    }
}