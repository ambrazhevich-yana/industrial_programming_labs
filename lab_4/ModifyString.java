import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 import java.util.ArrayList;
 import java.util.Scanner;
 import java.util.StringTokenizer;

public class ModifyString {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("string: ");
        String str = scanner.nextLine();
        System.out.print("separators: ");
        String separators = scanner.nextLine();
        System.out.print("int P: ");
        String P = scanner.next();
        String tmp;

        StringTokenizer token = new StringTokenizer(str, separators);
        ArrayList<String> lexems = new ArrayList<String>(0);
        ArrayList<String> words = new ArrayList<String>(0);
        ArrayList<String> palindroms = new ArrayList<String>(0);
        ArrayList<String> lexems_with_deleted_substr = new ArrayList<String>(0);
         while (token.hasMoreTokens()) {
            tmp = token.nextToken();
            lexems.add(tmp);
           if (!isNumeric(tmp)) {
                words.add(tmp);
            }
        }
        System.out.print("tokens: ");
        lexems.forEach((String s) -> System.out.printf("%s ", s));
        System.out.printf("%n");

        int[] int_array = new int[100];
        int int_array_size = 0;
        for (String g : lexems) {
            try {
                int_array[int_array_size] = Integer.parseInt(g);
            } catch (NumberFormatException e) {
                --int_array_size;
            }
            ++int_array_size;
        }
        System.out.print("numbers: ");
        for (int j = 0; j < int_array_size; j++) {
            System.out.print(int_array[j] + " ");
        }
        System.out.printf("%n");

        StringBuffer tmp1 = new StringBuffer(str);
        if (str.contains(P)){
            System.out.println("P here!");
            tmp1.insert(str.indexOf(P), Math.random()+ " ");}
        else {tmp1.insert(0 , Math.random() +" ");
            System.out.println("P not here!");}


        System.out.print("input string inserted random number: ");
        System.out.println(tmp1.toString());

        int min_length = Integer.MAX_VALUE;
        int min_index = lexems.size();
        for (int i = 0; i < lexems.size(); i++) {
            Pattern pattern = Pattern.compile("\\(([0-9]|[a-z])*\\)");
            Matcher matcher = pattern.matcher(lexems.get(i));
            while(matcher.find()){
                min_index = i;;
                }
            }
        for (int i = 0; i < lexems.size(); i++) {
            if (i != min_index){
                lexems_with_deleted_substr.add(lexems.get(i));
            }
        }

        System.out.print("lexemas with deleted (...) substring: ");
        for (int i = 0; i < lexems_with_deleted_substr.size(); i++) {
            System.out.print(lexems_with_deleted_substr.get(i) + " ");
        }
        System.out.println();

        System.out.print("palindroms: ");
        words.forEach((String s) -> {
            if (isPalindrom(s)) {
                System.out.printf("%s ", s);
                palindroms.add(s);
            }
        });

        Collections.sort(palindroms, (String a, String b) -> b.length()%2 - a.length()%2);
        System.out.printf("%n");
        System.out.print("sorted palindroms: ");
        palindroms.forEach((String s) -> System.out.printf("%s ", s));
    }
    public static boolean isPalindrom(String str) {
        StringBuffer tmp = new StringBuffer(str).reverse();
        return str.equals(tmp.toString());
    }
    public static boolean isNumeric(String string) {
        int intValue;
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}