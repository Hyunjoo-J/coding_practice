import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int R, C;
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		dp = new int[R][C];
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // 방문한 적 없다는 표시
			}
		}
		System.out.println(dfs(0, 0));
	}
	private static int dfs(int x, int y) {
		if(x == R - 1 && y == C - 1) //도착 - 실제로는 여기서부터 역으로 계산함, 이 부분을 몇 번 호출했는지가 정답
            return 1;
		if(dp[x][y] != -1) //이미 방문함
            return dp[x][y];
        dp[x][y] = 0; //초기화
        for(int i = 0; i < 4; ++i){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= R || ny < 0 || ny >= C)
                continue;
            if(map[x][y] > map[nx][ny])
                dp[x][y] += dfs(nx, ny);
        }
        return dp[x][y];
	}

}