import java.io.*;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(arithmetic_sequence(Integer.parseInt(br.readLine())));
		
	}
 
	public static int arithmetic_sequence(int num) {
		int cnt = 0; // 한수 카운팅
 
		if (num < 100) {
			return num;
		}
 
		else {
			cnt = 99;
			for (int i = 100; i <= num; i++) {
				int hun = i / 100; // 백의 자리
				int ten = (i / 10) % 10; // 십의 자리
				int one = i % 10;
 
				if ((hun - ten) == (ten - one)) { //각 자리가 수열을 이룸
					cnt++;
				}
			}
		}
 
		return cnt;
	}
 
}