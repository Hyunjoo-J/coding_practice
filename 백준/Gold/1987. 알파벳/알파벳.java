import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int r, c, ans;
    static char[][] board;
    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        alpha = new boolean[26];
        for(int i=0; i<r; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<line.length; j++) {
                String alpha = line[j];
                board[i][j] = alpha.charAt(0);
            }
        }
        alpha[board[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(ans);
    }
    private static void dfs(int x, int y, int sum){
        ans = Math.max(ans, sum);
        int nx, ny;
        for(int i = 0; i < 4; ++i){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || nx >= r || ny < 0 || ny >= c || alpha[board[nx][ny] - 'A'])
                continue;
            alpha[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, sum + 1);
            alpha[board[nx][ny] - 'A'] = false;
        }
    }
}