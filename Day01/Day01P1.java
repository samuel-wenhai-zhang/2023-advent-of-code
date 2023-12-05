import java.io.*;
import java.util.*;

public class Day01P1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day01.dat"));
        int sum = 0;

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String number = "";
            String curr = "";
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i + 1).matches("\\d")) {
                    number += line.substring(i, i + 1);
                    break;
                }
            }

            curr = "";
            for (int i = line.length() - 1; i >= 0; i--) {
                if (line.substring(i, i + 1).matches("\\d")) {
                    number += line.substring(i, i + 1);
                    break;
                }
            }
            sum += Integer.parseInt(number);

        }
        System.out.println(sum);
    }
}