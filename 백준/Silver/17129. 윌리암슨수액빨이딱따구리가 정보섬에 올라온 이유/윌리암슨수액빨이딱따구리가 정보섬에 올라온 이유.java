import java.util.*;
import java.io.*;
public class Main {
    static class Pair{
        int x, y, cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            String line = br.readLine();
            for(int j = 0; j < m; ++j){
                map[i][j] = line.charAt(j) - '0';
                if(map[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    map[i][j] = -1;
                }
            }
        }

        boolean flag = false;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        next:
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int nx, ny;
            for(int i = 0; i < 4; ++i){
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(map[nx][ny] == -1 || map[nx][ny] == 1)
                    continue;
                if(map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5){
                    flag = true;
                    sb.append("TAK\n").append(cur.cnt + 1);
                    break next;
                }
                q.add(new Pair(nx, ny, cur.cnt+1));
                map[nx][ny] = -1;
            }
        }
        if(!flag)
            sb.append("NIE");
        System.out.println(sb);
    }
}