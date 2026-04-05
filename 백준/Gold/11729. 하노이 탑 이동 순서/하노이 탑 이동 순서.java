import java.io.*;
import java.util.*;

public class Main {
    
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        hanoi(N, 1, 3, 2);
        System.out.println(count);
        System.out.println(sb);

    }

    static void move (int start, int to) {
        sb.append(start).append(" ").append(to).append("\n");
        count++;
    }

    static void hanoi(int N, int start, int to, int via) {
        if (N == 1) move(start, to);
        else {
            hanoi(N-1, start, via, to);
            move(start, to);
            hanoi(N-1, via, to, start);
        }
    }
}