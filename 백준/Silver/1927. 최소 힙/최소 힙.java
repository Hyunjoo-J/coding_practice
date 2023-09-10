import java.util.*;
import java.io.*;
public class Main {
    static int[] heap = new int[100000];
    static int size = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; ++i){
            int command = Integer.parseInt(br.readLine());
            if(command == 0){
                if(size == 0)
                    sb.append("0\n");
                else{
                    sb.append(findmin()+"\n");
                }
            }else{
                heap[size++] = command;
            }
        }
        System.out.print(sb.toString());
    }

    private static int findmin() {
        int min = heap[0];
        int idx = 0;
        for(int i = 1; i < size; ++i){
            if(min > heap[i]){
                min = heap[i];
                idx = i;
            }
        }
        heap[idx] = heap[--size];
        return min;
    }
}