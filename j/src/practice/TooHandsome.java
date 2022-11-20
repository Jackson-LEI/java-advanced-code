package practice;

import java.util.*;

public class TooHandsome {
    // https://pintia.cn/problem-sets/994805046380707840/problems/994805117167976448
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> num = new ArrayList<>();
        List<String> inputlist = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            num.add(sc.nextInt());
            for (int j = 0; j < num.get(i); j++) {
                if (num.get(i) != 1) {
                    inputlist.add(sc.next());
                } else {
                    sc.next();
                }
            }
        }

        int find = sc.nextInt();
        List<String> findList = new ArrayList<>();
        Set<String> delRepeat = new HashSet<>();
        List<String> outputList = new ArrayList<>();
        sc.nextLine();
        for (int i = 0; i < find; i++) {
            findList.add(sc.next());
            if (delRepeat.add(findList.get(i))) {
                outputList.add(findList.get(i));
            }
        }
        sc.close();

        outputList.removeAll(inputlist);
        if (outputList.isEmpty()) {
            System.out.println("No one is handsome");
            return;
        }

        Iterator<String> i = outputList.iterator();
        int count = 0;
        while (i.hasNext()) {
            if (count == outputList.size() - 1) {
                System.out.print(i.next());
            } else {
                System.out.print(i.next() + " ");
            }
            count++;
        }
    }
}
