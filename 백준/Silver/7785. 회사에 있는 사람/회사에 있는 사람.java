import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String M = st.nextToken();
            if (M.equals("enter")) {
                set.add(name);
            } else if (M.equals("leave")) {
                set.remove(name);
            }
        }

        List<String> result = new ArrayList<>(set);
        Collections.sort(result, Collections.reverseOrder());

        for (String s : result) {
            System.out.println(s);
        }
    }
}