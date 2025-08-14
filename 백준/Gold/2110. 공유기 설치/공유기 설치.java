import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1; // 최소 거리
        int right = house[N - 1] - house[0]; // 최대 거리
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid)) {
                answer = mid; // 설치 가능 → 거리 늘려보기
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    // 공유기 설치 가능 여부 확인
    static boolean canInstall(int distance) {
        int count = 1; // 첫 집에 설치
        int lastLocation = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - lastLocation >= distance) {
                count++;
                lastLocation = house[i];
            }
        }

        return count >= C;
    }
}
