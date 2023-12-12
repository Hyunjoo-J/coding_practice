import java.util.*;
import java.io.*;
public class Main {
    static int N, ans = Integer.MAX_VALUE;
    static int[][] player;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); //사람의 수
        player = new int[N][N];
        visit = new boolean[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j){
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int dep){
        if(dep == N){
            int start = 0;
            int link = 0;
            for(int i = 0; i < N; ++i){
                for(int j = i + 1; j < N; ++j){
                    if(visit[i] != visit[j]) continue;
                    if(visit[i])
                        start += player[i][j] + player[j][i];
                    else
                        link += player[i][j] + player[j][i];
                }
            }

            int diff = Math.abs(start - link);
            ans = Math.min(ans, diff);
            return;
        }
        visit[dep] = true;
        dfs(dep + 1);
        visit[dep] = false;
        dfs(dep + 1);
    }
}