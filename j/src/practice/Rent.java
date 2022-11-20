package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Rent {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805107638517760
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            ts.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }

        Iterator<Integer> it = ts.descendingIterator();
        ArrayList<Integer> l = new ArrayList<>();
        while (it.hasNext()) {
            l.add(it.next());
        }

        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < l.size(); j++) {
                if (Integer.valueOf(String.valueOf(s.charAt(i))).equals(l.get(j))) {
                    index.add(l.indexOf(l.get(j)));
                }
            }
        }

        StringBuilder arrString = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            if (i == l.size() - 1) {
                arrString.append(l.get(i));
            } else {
                arrString.append(l.get(i)).append(",");
            }
        }

        StringBuilder indexString = new StringBuilder();
        for (int i = 0; i < index.size(); i++) {
            if (i == index.size() - 1) {
                indexString.append(index.get(i));
            } else {
                indexString.append(index.get(i)).append(",");
            }
        }

        System.out.println("int[] arr = new int[]{" + arrString + "};");
        System.out.println("int[] index = new int[]{" + indexString + "};");
    }
}
