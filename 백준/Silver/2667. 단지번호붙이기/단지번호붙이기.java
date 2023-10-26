import java.util.*;
import java.io.*;
public class Main {
    static class Pair{
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; ++i){
            String line = br.readLine();
            for(int j = 0; j < N; ++j){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(map[i][j] == 0)
                    continue;
                if(visited[i][j])
                    continue;
                pq.add(bfs(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.print(sb);
    }

    private static Integer bfs(int x, int y) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        visited[x][y] = true;
        int num = 1;

        int nx, ny;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(int d = 0; d < 4; ++d){
                nx = cur.x + dx[d];
                ny = cur.y + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                if(visited[nx][ny] || map[nx][ny] == 0)
                    continue;
                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
                ++num;
            }

        }
        return num;
    }
}