import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int size = 1;
		for(int i = 0; i < k; ++i)
			size *= 2;
		char[] dir = new char[2*k];
		char last1 = 'A'; //다 접은 후의 row 위치 U,D
		char last2 = 'B'; //다 접은 후의 col 위치 L,R
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2*k; ++i) {
			dir[i] = st.nextToken().charAt(0);
			if(dir[i] == 'D' || dir[i] == 'U')//마지막 위아래 접은 방향 저장
				last1 = dir[i];
			else if(dir[i] == 'L' || dir[i] == 'R')//마지막 좌우 접은 방향 저장
				last2 = dir[i];
		}
		//basic[2][2] 배열을 만들어 각각의 상황 모두 처리하고, 그 배열들을 sb에 append하여 출력하는 형식
		int num = Integer.parseInt(br.readLine());
		int[][] basic = new int[2][2];
		if(last1 == 'U' && last2 == 'L') {//2X2 기준 좌상
			if(num == 0) {
				basic[0][0] = 0;
				basic[0][1] = 1;
				basic[1][0] = 2;
				basic[1][1] = 3;
						
			}else if(num == 1) {
				basic[0][0] = 1;
				basic[0][1] = 0;
				basic[1][0] = 3;
				basic[1][1] = 2;
			}else if(num == 2) {
				basic[0][0] = 2;
				basic[0][1] = 3;
				basic[1][0] = 0;
				basic[1][1] = 1;
			}else {
				basic[0][0] = 3;
				basic[0][1] = 2;
				basic[1][0] = 1;
				basic[1][1] = 0;
			}
		}
		else if(last1 == 'U' && last2 == 'R') {//2X2 기준 우상
			if(num == 0) {
				basic[0][0] = 1;
				basic[0][1] = 0;
				basic[1][0] = 3;
				basic[1][1] = 2;
						
			}else if(num == 1) {
				basic[0][0] = 0;
				basic[0][1] = 1;
				basic[1][0] = 2;
				basic[1][1] = 3;
			}else if(num == 2) {
				basic[0][0] = 3;
				basic[0][1] = 2;
				basic[1][0] = 1;
				basic[1][1] = 0;
			}else {
				basic[0][0] = 2;
				basic[0][1] = 3;
				basic[1][0] = 0;
				basic[1][1] = 1;
			}
		}
		else if(last1 == 'D' && last2 == 'L') {//2X2 기준 좌하
			if(num == 0) {
				basic[0][0] = 2;
				basic[0][1] = 3;
				basic[1][0] = 0;
				basic[1][1] = 1;
						
			}else if(num == 1) {
				basic[0][0] = 3;
				basic[0][1] = 2;
				basic[1][0] = 1;
				basic[1][1] = 0;
			}else if(num == 2) {
				basic[0][0] = 0;
				basic[0][1] = 1;
				basic[1][0] = 2;
				basic[1][1] = 3;
			}else {
				basic[0][0] = 1;
				basic[0][1] = 0;
				basic[1][0] = 3;
				basic[1][1] = 2;
			}
		}
		else {//2X2 기준 우하
			if(num == 0) {
				basic[0][0] = 3;
				basic[0][1] = 2;
				basic[1][0] = 1;
				basic[1][1] = 0;
						
			}else if(num == 1) {
				basic[0][0] = 2;
				basic[0][1] = 3;
				basic[1][0] = 0;
				basic[1][1] = 1;
			}else if(num == 2) {
				basic[0][0] = 1;
				basic[0][1] = 0;
				basic[1][0] = 3;
				basic[1][1] = 2;
			}else if(num == 3){
				basic[0][0] = 0;
				basic[0][1] = 1;
				basic[1][0] = 2;
				basic[1][1] = 3;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size/2; ++i) {
			for(int j = 0; j < size/2; ++j) {
				sb.append(basic[0][0]+" "+basic[0][1]+" ");
			}
			sb.append("\n");
			for(int j = 0; j < size/2; ++j) {
				sb.append(basic[1][0]+" "+basic[1][1]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}