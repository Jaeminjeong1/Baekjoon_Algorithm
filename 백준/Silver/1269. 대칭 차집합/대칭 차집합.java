import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();

        // 집합 A 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        // 집합 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            bSet.add(Integer.parseInt(st.nextToken()));
        }

        // 대칭 차집합 계산
        Set<Integer> symmetricDiff = new HashSet<>(aSet);
        symmetricDiff.addAll(bSet); // A ∪ B
        Set<Integer> intersection = new HashSet<>(aSet);
        intersection.retainAll(bSet); // A ∩ B
        symmetricDiff.removeAll(intersection); // (A ∪ B) - (A ∩ B)

        // 결과 출력
        System.out.println(symmetricDiff.size());
    }
}
