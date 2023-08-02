import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int size = Integer.parseInt(br.readLine());
            if (size == 1){
                System.out.println("#"+test_case);
                System.out.println("1");
                continue;
            }
            int[][] arr = new int[size][size];
            int x = 0;
            int y = 0;
            int dir = 0;
            for (int i = 1; i <= size * size; i++){
                arr[y][x] = i;
                x += dx[dir];
                y += dy[dir];
                if (x > size - 1 || x < 0 || y > size - 1 || y < 0 || arr[y][x] != 0){
                    x -= dx[dir];
                    y -= dy[dir];
                    dir = (dir + 1) % 4;
                    x += dx[dir];
                	y += dy[dir];
                }
			}
            System.out.println("#"+test_case);
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    System.out.print(arr[i][j] + " ");
            }
                System.out.println();
            }
        }
	}
}