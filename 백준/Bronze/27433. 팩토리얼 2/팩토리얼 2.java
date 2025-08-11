import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long result = factory(N);

        System.out.println(result);
        
    }
    
    static long factory (int n) {
        if (n == 0 || n == 1) return 1;
        return (long) n * factory(n - 1);
    }
}