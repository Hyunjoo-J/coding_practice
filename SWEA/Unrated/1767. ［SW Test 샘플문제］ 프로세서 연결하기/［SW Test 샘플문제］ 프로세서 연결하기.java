import java.util.*;
import java.io.*;
public class Solution {
    static class Core{
        int x, y;
        boolean connect;
        public Core(int x, int y, boolean connect) {
            this.x = x;
            this.y = y;
            this.connect = connect;
        }
    }
    static int N, num, ans, max;
    static int[][] map;
    static Core[] core;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; ++tc){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            core = new Core[12];
            num = 0;
            ans = Integer.MAX_VALUE;
            max = 0;
            for(int i = 0; i < N; ++i){ //코어 정보 저장
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; ++j){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1){
                        if(i == 0 || j == 0 || i == N - 1 || j == N - 1)
                            core[num] = new Core(i, j, true);
                        else
                            core[num] = new Core(i, j, false);
                        ++num;
                    }
                }
            }
            dfs(0, 0, 0, map);
            sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb.toString());
    }
    private static void dfs(int dep, int use, int len, int[][] copy){
        if(dep == num){
            if(use > max){
                ans = len;
                max = use;
            } else if(use == max) {
                ans = Math.min(ans, len);
            }
            return;
        }
        if(core[dep].connect == true){
            dfs(dep + 1, use + 1, len, copy);
        }else{
            for(int i = 0; i < 5; ++i){
                if(i == 4){
                    dfs(dep + 1, use, len, copy);
                    continue;
                }
                int nx = core[dep].x + dx[i];
                int ny = core[dep].y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                int tmp[][] = new int[N][N];
                for(int j = 0; j < N; ++j)
                    tmp[j] = copy[j].clone();
                int plus = find(dep, i, tmp);
                if(plus == -1)
                    continue;
                dfs(dep + 1,use + 1,len + plus, tmp);
            }
        }
    }
    private static int find(int dep, int dir, int[][] copy){
        int nx = core[dep].x;
        int ny = core[dep].y;
        int res = 0;
        while(true){
            nx += dx[dir];
            ny += dy[dir];
            if(nx == -1 || ny == -1 || nx == N || ny == N) {
                return res;
            }
            if(copy[nx][ny] != 0)
                break;
            copy[nx][ny] = 2;
            ++res;
        }
        return -1;
    }
}