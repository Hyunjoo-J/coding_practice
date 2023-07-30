import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<2*n; i++) {
            for(int j=0; j<n; j++) {
                if(i%2==1) {
                    if(j%2==1) {
                        sb.append("*");
                    }else
                        sb.append(" ");
                }else
                if(j%2==1) {
                    sb.append(" ");
                }else
                    sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}