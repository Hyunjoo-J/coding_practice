import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = (n - 1) * 4 + 1;
        arr = new char[size][size];
        int mid = size/2;
        for(int i = 0; i<size;i++){
            for (int j = 0; j < size;j++){
                arr[i][j] = ' ';
            }
        }
        star(0,size);
        for(int i = 0; i<size;i++){
            for (int j = 0; j < size;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
    public static void star(int s, int size){
        if(size <= s)
            return;
        for(int i = s; i < size; i++){
            arr[s][i] = '*';
            arr[i][s] = '*';
            arr[size - 1][i] = '*';
            arr[i][size - 1] = '*';
        }
        star(s+2,size-2 );

    }
}