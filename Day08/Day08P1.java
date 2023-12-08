import java.io.*;
import java.util.*;


public class Day08P1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day08.dat"));
        String directions = in.nextLine();
        in.nextLine();

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while (in.hasNextLine()) {
            String[] u = in.nextLine().split("\\W+");
            map.put(u[0], new String[] {u[1], u[2]});
        }

        String current = "AAA";
        int step = 0;
        while (!current.equals("ZZZ")) {
            int s = step % directions.length();
            String dir = directions.substring(s, s + 1);
            if (dir.equals("L")) {
                current = map.get(current)[0];
            }
            else {
                current = map.get(current)[1];
            }
            step++;
        }
        System.out.println(step);
    }
}
