package practice;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UniqueHappiness {
    //https://pintia.cn/problem-sets/994805046380707840/problems/1111914599412858886
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        sc.close();

        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        TreeMap<Integer, HashSet<Integer>> map = new TreeMap<>();
        while (from <= to) {
            boolean isHappy = true;
            String s = String.valueOf(from);
            while (true) {
                for (int j = 0; j < s.length(); j++) {
                    sum = (int) (sum + Math.pow(Integer.parseInt(String.valueOf(s.charAt(j))), 2));
                }
                if (!(set.add(sum))) {
                    isHappy = false;
                    sum = 0;
                    break;
                }
                if (sum == 1) {
                    sum = 0;
                    break;
                }
                s = String.valueOf(sum);
                sum = 0;
            }
            if (isHappy) {
                map.put(from, new HashSet<>(set));
            }
            set.clear();
            from++;
        }

        HashSet<Integer> allData = new HashSet<>();
        for(HashSet<Integer> i : map.values()){
            allData.addAll(i);
        }

        TreeMap<Integer, HashSet<Integer>> subMap = new TreeMap<>();
        for(Integer i : map.keySet()){
            if(!(allData.contains(i))){
                subMap.put(i,map.get(i));
            }
        }

        if(subMap.isEmpty()){
            System.out.println("SAD");
            return;
        }

        for(Map.Entry<Integer,HashSet<Integer>> entry: subMap.entrySet()){
            int a = entry.getKey();
            if(new BigInteger(String.valueOf(a)).isProbablePrime(2)){
                System.out.println(a + " " + subMap.get(a).size() * 2);
            }else{
                System.out.println(a + " " + subMap.get(a).size());
            }
        }
    }
}
