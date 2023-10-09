import java.io.*;
import java.util.*;

public class Solution {
    static int N, W, H, min;
    static int[][] map, copy;
    static int[] num;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            copy = new int[H][W];
            num = new int[N];
            min = Integer.MAX_VALUE;
            for(int i = 0; i < H; ++i) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; ++j) {
                    map[i][j] = copy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0);
            sb.append("#"+test_case+" "+min+"\n");
        }
        System.out.print(sb.toString());
    }

    private static void perm(int cnt){
        if(cnt == N){
            run();
            min = Math.min(min, cntMap());
            mapcopy();
            return;
        }
        for(int i = 0; i < W; ++i){
            num[cnt] = i;
            perm(cnt + 1);
        }
    }

    private static int cntMap() {
        int cnt = 0;
        for(int i = 0; i < H; ++i){
            for(int j = 0; j < W; ++j){
                if(map[i][j] != 0)
                    ++cnt;
            }
        }
        return cnt;
    }

    private static void run(){
        int x = 0;
        int y = 0;
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < H; ++j){
                if(map[j][num[i]] != 0){
                    x = j;
                    y = num[i];
                    break;
                }
            }
            bfs(x, y);
            blockdown();
        }
    }

    private static void blockdown(){
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < W; ++i){
            for(int j = 0; j < H; ++j){
                if(map[j][i]  != 0){
                    s.add(map[j][i]);
                }
            }
            for(int j = H - 1; j >= 0; --j){
                if(s.isEmpty())
                    map[j][i] = 0;
                else
                    map[j][i] = s.pop();
            }
        }
    }

    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y, map[x][y]});
        map[x][y] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int power = cur[2];

            for(int i = 1; i < power; ++i){
                for(int j = 0; j < 4; ++j){
                    int nx = cur[0] + dr[j] * i;
                    int ny = cur[1] + dc[j] * i;

                    if(nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == 0)
                        continue;
                    if(map[nx][ny] != 0){
                        q.add(new int[] {nx, ny, map[nx][ny]});
                        map[nx][ny] = 0;
                    }

                }
            }
        }
    }

    private static void mapcopy(){
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                map[i][j] = copy[i][j];
            }
        }
    }
}