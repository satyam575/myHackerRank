import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the encryption function below.
    static String encryption(String s) {
        
        s = s.replaceAll("//s","");
        double lengthSq = Math.sqrt(s.length()) ;
        int cols = (int)Math.ceil(lengthSq);
        int rows = (int)Math.floor(lengthSq);
         StringBuilder sb = new StringBuilder();
        if(!(rows * cols >= s.length() )){
            rows++ ;
        }
            
        char[][] grid = new char[rows][cols] ;
        int k =0; 
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(k==s.length())
                    break ;
                grid[i][j]=s.charAt(k);
                k++ ;
            }
        }
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                if(grid[j][i] == '\0')
                    break ;
               sb.append(String.valueOf(grid[j][i] ));
            }sb.append(" ");
        }
        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
