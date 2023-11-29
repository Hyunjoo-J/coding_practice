import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static final char EMPTY = 'E';
    private static final char LEPRECHAUN = 'L';
    private static final char TROLL = 'T';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N, next;
        char[] type = new char[1001];
        int[] cost = new int[1001];
        List<Integer>[] list = new ArrayList[1001];
        for (int i = 0; i < 1001; ++i)
            list[i] = new ArrayList<>();
        while ((N = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 1; i <= N; ++i)
                list[i] = new ArrayList<>();
            for (int i = 1; i <= N; ++i) {
                st = new StringTokenizer(br.readLine());
                type[i] = st.nextToken().charAt(0);
                cost[i] = Integer.parseInt(st.nextToken());
                while ((next = Integer.parseInt(st.nextToken())) != 0) {
                    list[i].add(next);
                }
            }
            if (check(list, N, type, cost)) {
                sb.append("Yes\n");
            } else {
                sb.append("No\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean check(List<Integer>[] list, int N, char[] type, int[] cost) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        boolean[][] visited = new boolean[N + 1][501];
        visited[1][0] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.v == N)
                return true;
            int price = 0;
            for(int next : list[cur.v]){
                switch (type[next]){
                    case EMPTY :
                        price = cur.w;
                        break;
                    case LEPRECHAUN:
                        price = Math.max(cur.w, cost[next]);
                        break;
                    case TROLL:
                        price = cur.w - cost[next];
                        break;
                }
                if(price >= 0 && !visited[next][price]){
                    visited[next][price] = true;
                    q.add(new Node(next, price));
                }
            }
        }
        return false;
    }
}