import java.util.*;
import java.io.*;

public class Solution {
    static class Core {
        int x, y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
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
        for (int tc = 1; tc <= T; ++tc) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            core = new Core[12];
            num = 0;
            ans = Integer.MAX_VALUE;
            max = 0;
            for (int i = 0; i < N; ++i) { //코어 정보 저장
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            ++max;
                        } else {
                            core[num] = new Core(i, j);
                            ++num;
                        }
                    }
                }
            }
            dfs(0, max, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int dep, int use, int len) {
        if (dep == num) {
            if (use > max) {
                ans = len;
                max = use;
            } else if (use == max) {
                ans = Math.min(ans, len);
            }
            return;
        }
        for (int i = 0; i < 5; ++i) {
            if (i == 4) {
                dfs(dep + 1, use, len);
                continue;
            }
            boolean flag = false;
            int nx = core[dep].x, ny = core[dep].y;
            while(true){
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N){
                    flag = true;
                    break;
                }
                if(map[nx][ny] != 0){
                    break;
                }
                map[nx][ny] = 2;
                ++len;
            }
            if(flag){
                dfs(dep + 1, use + 1, len);
            }
            while(true) { // 원 상태로 돌려놓기
                nx -= dx[i];
                ny -= dy[i];
                if(nx == core[dep].x && ny == core[dep].y)
                    break;
                map[nx][ny] = 0;
                --len;
            }
        }
    }
}