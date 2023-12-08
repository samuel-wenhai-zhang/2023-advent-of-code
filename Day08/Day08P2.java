import java.io.*;
import java.util.*;


public class Day08P2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day08.dat"));
        String directions = in.nextLine();
        in.nextLine();

        TreeMap<String, String[]> map = new TreeMap<String, String[]>();
        while (in.hasNextLine()) {
            String[] u = in.nextLine().split("\\W+");
            map.put(u[0], new String[] {u[1], u[2]});
        }

        ArrayList<String> currents = new ArrayList<String>();


        for (String s : map.keySet()) {
            if (s.endsWith("A")) {
                currents.add(s);
            }
        }
        
        int step = 0;
        outerloop:
        while (true) {
            for (int i = 0; i < currents.size(); i++) {
                String current = currents.get(i);
                int s = step % directions.length();
                String dir = directions.substring(s, s + 1);
                if (dir.equals("L")) {
                    currents.set(i, map.get(current)[0]);
                }
                else {
                    currents.set(i, map.get(current)[1]);
                }
            }
            step++;
            
            
            for (int i = 0; i < currents.size(); i++) {
                if (!currents.get(i).endsWith("Z")) {
                    continue outerloop;
                }
            }
            break outerloop;
        }

        
        System.out.println(step);
    }
}
