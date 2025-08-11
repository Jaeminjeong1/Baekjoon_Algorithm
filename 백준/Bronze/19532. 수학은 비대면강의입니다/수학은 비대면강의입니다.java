/*
1. 아이디어
    - BFS
    - a,b,c,d,e,f 각각 받고 이중 for문으로 연립방적식 만족하는거 찾기.
2. 시간 복잡도
    - 이중 for문 O(N^2)
3. 자료구조
    - 없음.
***** 이건 지피티피셜임. 판별식이 뭐지
 */
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        // 판별식
        int D = a * e - b * d;
        // 크래머 공식
        int x = (c * e - b * f) / D;
        int y = (a * f - c * d) / D;
        System.out.println(x + " " + y);
    }
}
