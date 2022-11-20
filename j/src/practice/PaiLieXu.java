package practice;

import java.util.*;

public class PaiLieXu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for (int b = 0; b < n; b++) {
            array[b] = b + 1;
        }

        StringBuffer str = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            str.append(array[i]);
        }
        String stf = new StringBuffer(str).reverse().toString();
        int r = Integer.parseInt(new String(str));
        int f = Integer.parseInt(stf);
        sc.close();

        for (int i = r; i <= f; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                set.add(ch);
            }

            if (set.size() == n) {
                list.add(i);
            }
            set.clear();
        }
        System.out.println(list.get(k - 1));
    }

}