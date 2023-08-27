import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge>{
        int x, y, weight;
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M, island;
    static int[] parents;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(); //간선 정보
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < M; ++j){
                if(!visited[i][j] && map[i][j] == 1){
                    island++;
                    bfs(new Node(i, j));
                }
            }
        }

        visited = new boolean[N][M];
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < M; ++j){
                if(map[i][j] != 0){
                    bridge(new Node(i, j), map[i][j]);
                }
            }
        }
        parents = new int[island + 1];
        for(int i = 0; i < island + 1; ++i){
            parents[i] = i;
        }
        int size = pq.size();
        int res = 0;
        int cnt = 0;
        for(int i = 0; i < size; ++i){
            Edge tmp = pq.poll();
            int a = find(tmp.x);
            int b = find(tmp.y);
            if(a == b)
                continue;
            union(tmp.x, tmp.y);
            res += tmp.weight;
            ++cnt;
            if(cnt == island - 1)
                break;
        }
        if(res == 0 || cnt != island - 1)
            System.out.println("-1");
        else
            System.out.println(res);
    }
    private static int find(int v){
        if(parents[v] == v)
            return v;
        return parents[v] = find(parents[v]);
    }
    private static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot != bRoot) {
            parents[aRoot] = b;
        } else {
            return;
        }
    }
    private static void bridge(Node cur, int num){
        int x = cur.x;
        int y = cur.y;
        int len = 0;
        for(int i = 0; i < 4; ++i){
            while(true){
                x = x + dx[i];
                y = y + dy[i];

                if(x >= 0 && y >= 0 && x < N && y < M){
                    if(map[x][y] == num){
                        len = 0;
                        x = cur.x;
                        y = cur.y;
                        break;
                    }else if(map[x][y] == 0)
                        len++;
                    else{
                        if(len > 1){
                            pq.add(new Edge(num, map[x][y], len));
                        }
                        len = 0;
                        x = cur.x;
                        y = cur.y;
                        break;
                    }
                }else{
                    len = 0;
                    x = cur.x;
                    y = cur.y;
                    break;
                }
            }
        }
    }

    private static void bfs(Node now){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(now.x,now.y));
        visited[now.x][now.y] = true;
        map[now.x][now.y] = island;
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            int x = tmp.x;
            int y = tmp.y;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] || map[nx][ny] != 1) continue;
                visited[nx][ny] = true;
                map[nx][ny] = island;
                q.offer(new Node(nx, ny));
            }
        }
    }
}