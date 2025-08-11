
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}