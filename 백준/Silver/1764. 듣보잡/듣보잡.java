import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> unheard = new HashSet<>();
        List<String> result = new ArrayList<>();

        // 듣도 못한 사람 입력
        for (int i = 0; i < N; i++) {
            unheard.add(br.readLine());
        }

        // 보도 못한 사람 입력 및 확인
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (unheard.contains(name)) {  // 듣도 못한 사람 명단에 있으면 추가
                result.add(name);
            }
        }

        // 사전순 정렬
        Collections.sort(result);

        // 결과 출력
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb.toString()); // 한 번에 출력하여 성능 최적화
    }
}
