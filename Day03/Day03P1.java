import java.io.*;
import java.util.*;

public class Day03P1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day03.dat"));
        ArrayList<String> lines = new ArrayList<String>();
        while (in.hasNextLine()) {
            lines.add(in.nextLine());
        }

        int sum = 0;

        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);

            String num = "";
            boolean isPart = false;

            for (int col = 0; col < line.length(); col++) {
                char c = line.charAt(col);

                if (Character.isDigit(c)) {
                    num += c;
                    if (row - 1 >= 0 && lines.get(row-1).charAt(col) != '.' && !Character.isDigit(lines.get(row-1).charAt(col))) {
                        isPart = true;
                    }
                    if (row - 1 >= 0 && col + 1 < line.length() && lines.get(row-1).charAt(col + 1) != '.' && !Character.isDigit(lines.get(row-1).charAt(col + 1))) {
                        isPart = true;
                    }
                    if (col + 1 < line.length() && lines.get(row).charAt(col + 1) != '.' && !Character.isDigit(lines.get(row).charAt(col + 1))) {
                        isPart = true;
                    }
                    if (row + 1 < lines.size() && col + 1 < line.length() && lines.get(row+1).charAt(col+1) != '.' && !Character.isDigit(lines.get(row+1).charAt(col+1))) {
                        isPart = true;
                    }
                    if (row + 1 < lines.size() && lines.get(row + 1).charAt(col) != '.' && !Character.isDigit(lines.get(row+1).charAt(col))) {
                        isPart = true;
                    }
                    if (row + 1 < lines.size() && col - 1 >= 0 && lines.get(row+1).charAt(col-1) != '.' && !Character.isDigit(lines.get(row+1).charAt(col-1))) {
                        isPart = true;
                    }
                    if (col - 1 >= 0 && lines.get(row).charAt(col-1) != '.' && !Character.isDigit(lines.get(row).charAt(col-1))) {
                        isPart = true;
                    }
                    if (row - 1 >= 0 && col - 1 >= 0 && lines.get(row-1).charAt(col - 1) != '.' && !Character.isDigit(lines.get(row-1).charAt(col - 1))) {
                        isPart = true;
                    }
                }
                else if (isPart) {
                    sum += Integer.parseInt(num);
                    num = "";
                    isPart = false;
                }
                else {
                    num = "";
                }

            }

        }
        System.out.println(sum);
    }
}