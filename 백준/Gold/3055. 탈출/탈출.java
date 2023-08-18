import java.util.*;
import java.io.*;

public class Main {
	private static class Type{
		int x;
		int y;
		int dis;
		public Type(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis; //0 물 1 고슴도치
		}
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		int cnt = 1;
		boolean[][] visited = new boolean[R][C];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Deque<Type> q = new ArrayDeque<Type>();
		int ax = 0, ay = 0;
		for(int i = 0; i < R; ++i) {
			String line = br.readLine();
			for(int j = 0; j < C; ++j) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'D') {
					ax = i;
					ay = j;
				}else if(map[i][j] == '*') {
					q.addFirst(new Type(i, j, -1));
				}else if(map[i][j] == 'S') {
					q.addLast(new Type(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()) {
			if(cnt == 0) {
				System.out.println("KAKTUS");
				return;
			}
			Type tmp = q.poll();
			int nx, ny;
			if(tmp.dis == -1) {
				for(int i = 0; i < 4; ++i) {
					nx = tmp.x + dx[i];
					ny = tmp.y + dy[i];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if(map[nx][ny] == '.') {
						map[nx][ny] = '*';
						q.add(new Type(nx, ny, -1));
					}
				}
			}else if(tmp.dis > -1) {
				if(tmp.x == ax && tmp.y == ay) {
					System.out.println(tmp.dis);
					return;
				}
				--cnt;
				for(int i = 0; i < 4; ++i) {
					nx = tmp.x + dx[i];
					ny = tmp.y + dy[i];
					if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny])
						continue;
					if(map[nx][ny] == '.' || map[nx][ny] == 'D') {
						visited[nx][ny] = true;
						q.add(new Type(nx, ny, tmp.dis + 1));
						++cnt;
					}
				}
			}
			
		}

	}

}