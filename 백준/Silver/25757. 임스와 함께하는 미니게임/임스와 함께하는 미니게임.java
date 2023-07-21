import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char c = sc.next().charAt(0);
        Set<String> ID = new HashSet<>();
        
        for (int i = 0; i < n; i++){
            String id;
            id = sc.next();
            ID.add(id);
        }
        int size = ID.size();
        if (c == 'Y')
            System.out.println(size);
        else if(c == 'F')
            System.out.println(size/2);
        else if (c == 'O')
            System.out.println(size/3);
    }
}