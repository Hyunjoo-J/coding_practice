import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, key, cnt;

        public Node(int x, int y, int key, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.key = key;
            this.cnt = cnt;
        }

    }

    static int N, M, sx, sy;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][64];
        String line;
        for (int i = 0; i < N; ++i) {
            line = br.readLine();
            for (int j = 0; j < M; ++j) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(sx, sy, 0, 0));
        visited[sx][sy][0] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(map[cur.x][cur.y] == '1')
                return cur.cnt;
            int key = cur.key;
            for (int i = 0; i < 4; ++i) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if(visited[nx][ny][key] || map[nx][ny] == '#')
                    continue;
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    int nkey = key | 1 << (map[nx][ny] - 'a');
                    q.offer(new Node(nx, ny, nkey, cur.cnt + 1));
                    visited[nx][ny][nkey] = true;
                }else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'Z'){
                    if((key &  1 << (map[nx][ny] - 'A')) > 0){
                        q.offer(new Node(nx, ny, key, cur.cnt + 1));
                        visited[nx][ny][key] = true;
                    }
                }else{
                    q.offer(new Node(nx, ny, key, cur.cnt + 1));
                    visited[nx][ny][key] = true;
                }

            }
        }
        return -1;
    }

}