import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 상근이가 가지고 있는 숫자 카드 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> cardSet = new HashSet<>();

        // 숫자 카드 입력 (HashSet에 저장)
        String[] arr1 = br.readLine().split(" ");
        for (String a : arr1) {
            cardSet.add(Integer.parseInt(a));
        }
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            cardSet.add(Integer.parseInt(st.nextToken()));
//        }


        // 확인할 숫자 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        // 확인할 숫자 입력 및 결과 출력
        String[] arr2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(arr2[i]);
            sb.append(cardSet.contains(num) ? "1 " : "0 ");
        }
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            int num = Integer.parseInt(st.nextToken());
//            sb.append(cardSet.contains(num) ? "1 " : "0 ");
//        }

        // 결과 출력
        System.out.println(sb.toString().trim());
    }
}
