import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>(list);
        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}
