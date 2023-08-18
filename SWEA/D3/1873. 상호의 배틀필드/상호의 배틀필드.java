import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int H, W, N;
		char[][] map;
		for (int tc = 1; tc <= T; ++tc) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			int x = 0, y = 0, dir = 0;
			for (int i = 0; i < H; ++i) {
				String line = br.readLine();
				for (int j = 0; j < W; ++j) {
					map[i][j] = line.charAt(j);
					switch (map[i][j]) {
					case '^': // 상
						x = i;
						y = j;
						dir = 1;
						break;
					case 'v': // 하
						x = i;
						y = j;
						dir = 2;
						break;
					case '<': // 좌
						x = i;
						y = j;
						dir = 3;
						break;
					case '>': // 우
						x = i;
						y = j;
						dir = 4;
						break;

					}
				}
			}
			N = Integer.parseInt(br.readLine());
			String line = br.readLine();
			for (int i = 0; i < N; ++i) {
				char com = line.charAt(i);
				int idx = 0;
				switch(com) {
				case 'U' :
					dir = 1;
					map[x][y] = '^';
					if(x > 0 && map[x-1][y] == '.') {
						map[x - 1][y] = map[x][y];
						map[x][y] = '.';
						x -= 1;
					}
					break;
				case 'D' : 
					dir = 2;
					map[x][y] = 'v';
					if(x < H - 1 && map[x + 1][y] == '.') {
						map[x+1][y] = map[x][y];
						map[x][y] = '.';
						x += 1;
					}
					break;
				case 'L' :
					dir = 3;
					map[x][y] = '<';
					if(y > 0 && map[x][y - 1] == '.') {
						map[x][y - 1] = map[x][y];
						map[x][y] = '.';
						y -= 1;
					}
					break;
				case 'R' :
					dir = 4;
					map[x][y] = '>';
					if(y < W - 1 && map[x][y + 1] == '.') {
						map[x][y + 1] = map[x][y];
						map[x][y] = '.';
						y += 1;
					}
					break;
				case 'S' :
					switch(dir) {
					case 1:
						idx = x;
						while(true) {
							if(idx - 1 < 0 || map[idx - 1][y] == '#')
								break;
							if(map[idx - 1][y] == '*') {
								map[idx - 1][y] = '.';
								break;
							}
							idx--;
						}
						break;
					case 2:
						idx = x;
						while(true) {
							if(idx + 1 >= H || map[idx + 1][y] == '#')
								break;
							if(map[idx + 1][y] == '*') {
								map[idx + 1][y] = '.';
								break;
							}
							idx++;
						}
						break;
					case 3:
						idx = y;
						while(true) {
							if(idx - 1 < 0 || map[x][idx - 1] == '#')
								break;
							if(map[x][idx - 1] == '*') {
								map[x][idx - 1] = '.';
								break;
							}
							idx--;
						}
						break;
					case 4:
						idx = y;
						while(true) {
							if(idx + 1 >= W || map[x][idx + 1] == '#')
								break;
							if(map[x][idx + 1] == '*') {
								map[x][idx + 1] = '.';
								break;
							}
							idx++;
						}
						break;
					}
				}
			}
			sb.append("#"+tc+" ");
			for(int i = 0; i < H; ++i) {
				for(int j = 0; j < W; ++j) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());

	}

}