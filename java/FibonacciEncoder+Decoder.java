import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
 
 
 
class Result {
 
   /*
    * Complete the 'fibCypher' function below.
    *
    * The function is expected to return a STRING.
    * The function accepts following parameters:
    *  1. CHARACTER option
    *  2. INTEGER num1
    *  3. INTEGER num2
    *  4. CHARACTER key
    *  5. STRING msg
    */
   public static String fibCypher(char option, int num1, int num2, char key, String msg) { 

      List<Integer> fib = new ArrayList<Integer>(); 

      fib.add(num1); 

      fib.add(num2); 

      String result = ""; 

      int offset; 

      if (option == 'E') { 

         for (int i = 0; i < msg.length(); i++) { 

            if (i % 2 == 0) offset = ((key + (fib.get(i) % 26) - 97) % 26) + 97; 

            else { 

               offset = (key - (fib.get(i) % 26) - 97) % 26; 

               if (offset < 0) offset = 26 + offset + 97; 

               else offset += 97; 

            } 

            char currChar = msg.charAt(i); 

            result += (3 * offset) + currChar; 

            if (i != msg.length() - 1){ 

               result += " "; 

               fib.add((fib.get(i) + fib.get(i + 1)) % 26); 

         }  

      } 

      } else if (option == 'D') { 

         String[] nums = msg.split(" "); 

         for (int i = 0; i < nums.length; i++) { 

            if (i % 2 == 0) offset = ((key + (fib.get(i) % 26) - 97) % 26) + 97; 

            else { 

               offset = (key - (fib.get(i) % 26) - 97) % 26; 

               if (offset < 0) offset = 26 + offset + 97; 

               else offset += 97; 

            } 

            result += (char)(Integer.parseInt(nums[i]) - (3 * offset)); 

            fib.add((fib.get(i) + fib.get(i + 1)) % 26); 

         } 

      } else return null; 

      return result; 

      } 

      public class Solution {
         
         public static void main(String[] args) throws IOException {
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

             char option = bufferedReader.readLine().charAt(0);

             int num1 = Integer.parseInt(bufferedReader.readLine().trim());

             int num2 = Integer.parseInt(bufferedReader.readLine().trim());

             char key = bufferedReader.readLine().charAt(0);

             String msg = bufferedReader.readLine();

             String result = Result.fibCypher(option, num1, num2, key, msg);

             bufferedWriter.write(result);
             bufferedWriter.newLine();

             bufferedReader.close();
             bufferedWriter.close();
         }
}
