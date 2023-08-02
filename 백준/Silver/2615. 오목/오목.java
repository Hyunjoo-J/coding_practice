import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[19][19];
		boolean[][][] visited = new boolean[19][19][4];
		for(int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(arr[i][j] == 0 || (visited[i][j][0] && visited[i][j][1] && visited[i][j][2] && visited[i][j][0]))
					continue;
				else if(arr[i][j] == 1) {
					int k = 1;
					visited[i][j][0] = true;
					visited[i][j][1] = true;
					visited[i][j][2] = true;
					int n1 = 1,n2 = 1,n3 = 1,n4 =1;
					while(j+k <19 && arr[i][j+k] == 1 && !visited[i][j+k][0]) {
						visited[i][j+k][0] = true;;
						n1++;
						k++;
					}
					if(n1 == 5) {
						System.out.println("1");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k =1;
					while(i+k<19 && arr[i+k][j] == 1 && !visited[i+k][j][1]) {
						visited[i+k][j][1] = true;
						n2++;
						k++;
					}
					if(n2 == 5) {
						System.out.println("1");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k = 1;
					while(j+k <19 && i+k <19 && arr[i+k][j+k] == 1 && !visited[i+k][j+k][2]) {
						visited[i+k][j+k][2] = true;
						n3++;
						k++;
					}
					if(n3 == 5) {
						System.out.println("1");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k = 1;
					while(j-k >= 0 && i+k <19 && arr[i+k][j-k] == 1 && !visited[i+k][j-k][3]) {
						visited[i+k][j-k][3] = true;
						n4++;
						k++;
					}
					if(n4 == 5) {
						System.out.println("1");
						System.out.println((i+k)+" "+(j-k+2));
						return;
					}
				}
				else if(arr[i][j] == 2) {
					int k = 1;
					visited[i][j][0] = true;
					visited[i][j][1] = true;
					visited[i][j][2] = true;
					int n1 = 1,n2 = 1,n3 = 1, n4 = 1;
					while(j+k <19 && arr[i][j+k] == 2 && !visited[i][j+k][0]) {
						visited[i][j+k][0] = true;
						n1++;
						k++;
					}
					if(n1 == 5) {
						System.out.println("2");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k = 1;
					while(i+k <19 && arr[i+k][j] == 2 && !visited[i+k][j][1]) {
						visited[i+k][j][1] = true;
						n2++;
						k++;
					}
					if(n2 == 5) {
						System.out.println("2");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k = 1;
					while(i+k <19 && j+k <19&&arr[i+k][j+k] == 2 && !visited[i+k][j+k][2]) {
						visited[i+k][j+k][2] = true;
						n3++;
						k++;
					}
					if(n3 == 5) {
						System.out.println("2");
						System.out.println((i+1)+" "+(j+1));
						return;
					}
					k = 1;
					while(j-k >=0 && i+k <19 && arr[i+k][j-k] == 2 && !visited[i+k][j-k][3]) {
						visited[i+k][j-k][3] = true;
						n4++;
						k++;
					}
					if(n4 == 5) {
						System.out.println("2");
						System.out.println((i+k)+" "+(j-k+2));
						return;
					}
				}
				
			}
		}
		System.out.println("0");
	}
}