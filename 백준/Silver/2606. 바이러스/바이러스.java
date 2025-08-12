/*
1. 아이디어
    - DFS, BFS 둘다 가능
    - DFS 로 구현함.
    - List of List 로 각 노드의 연결을 받음.
    - 1번이 감염 되었다고 가정했음으로 첫 감염 노드 파라미터 값 1
    - node 값 받으면 visited의 boolean값 true로 바꿔주고, count 1 증가
    - 이 노드와 연결된 노드를 for문 돌면서 visit하지 않은 곳이면 DFS로 방문.
2. 시간 복잡도
    - O(N + E), N -> 노드수, E -> 간선의 수
    - 1초에 처리할 . 있는 연산 수는 대략 10^8 ~ 10^9
3. 자료구조
    - 방문 여부 boolean[]
    - 노드 간의 연결 저장 ArrayList<ArrayList<Integer>>
 */
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());


        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[N + 1];
        DFS(1);

        System.out.println(count - 1);


    }

    static void DFS(int node) {
        visited[node] = true;
        count++;

        for (Integer i : list.get(node)) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }
}