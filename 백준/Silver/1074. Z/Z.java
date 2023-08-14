import java.io.*;
import java.util.*;

import java.io.IOException;

public class Main {
	static int n,r,c,cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int size = 1;
		for(int i = 0; i < n; ++i) {
			size *= 2;
		}
		divide(0, 0, size);
	}
	private static void divide(int x, int y, int size) {
		if(size == 1) {
			System.out.println(cnt);
			return;
		}
		if(r < x + size/2 && c < y + size/2) {
			divide(x, y, size/2);
		}else if(r < x + size/2 && c >= y + size/2) {
			cnt += size*size/4;
			divide(x, y+size/2, size/2);
		}else if(r >= x + size/2 && c < y + size/2) {
			cnt += (size*size/2);
			divide(x+size/2, y, size/2);
		}else{
			cnt += (size*size/4)*3;
			divide(x+size/2, y+size/2, size/2);
		}
		
	}

}