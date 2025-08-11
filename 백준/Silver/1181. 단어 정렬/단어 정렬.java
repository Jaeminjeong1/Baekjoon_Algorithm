import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        list.sort((a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });

        for (String i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
