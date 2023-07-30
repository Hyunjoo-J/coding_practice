import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int r = 2*n - 1;
        int c = 4*n - 3;
        char[][] arr = new char[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                arr[i][j] =  ' ';
            }
        }
        for(int i = 0 ; i < n; i++){
            arr[0][i] = '*';
            arr[0][c-1-i] = '*';
            arr[r-1][i] = '*';
            arr[r-1][c-1-i] = '*';
        }
        for(int i = 1; i < n ; i++){
            arr[i][i] = '*';
            arr[i][i+n-1] = '*';
            arr[i][c - 1 -i] = '*';
            arr[i][c - i - n] = '*';
            arr[r-1-i][i] = '*';
            arr[r-1-i][i+n-1] = '*';
            arr[r-1-i][c - 1 -i] = '*';
            arr[r-1-i][c - i - n] = '*';
        }
        for(int i = 0; i < r/2+1; i++){
            for(int j = 0; j < c - i; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        for(int i = r/2+1; i < r; i++){
            for(int j = 0; j < r+i ; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}