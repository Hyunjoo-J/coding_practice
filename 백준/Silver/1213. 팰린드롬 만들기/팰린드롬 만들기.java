import java.io.*;
import java.util.*;

public class Main {
	static String input;
	static int[] alpha = new int[26];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		for(int i = 0, size = input.length(); i < size; ++i) {
			int idx = input.charAt(i) - 'A';
			alpha[idx]++;
		}
		int solo = 0;
		for(int i = 0;i < 26; ++i) {
			if(alpha[i] % 2 != 0)
				++solo;
		}
		String ans = "";
		StringBuilder sb = new StringBuilder();
		if(solo > 1)
			ans += "I'm Sorry Hansoo";
		else {
			for(int i = 0; i < 26; ++i) {
				for( int j = 0; j <alpha[i]/2; ++j) {
					sb.append((char)(i + 65));
				}
			}
			ans += sb.toString();
			String fin = sb.reverse().toString();
			sb = new StringBuilder();
			for(int i = 0; i < 26; ++i) {
				if(alpha[i]%2 == 1) {
					sb.append((char)(i+65));
				}
			}
			ans += sb.toString()+fin;
		}
		System.out.println(ans);

	}

}