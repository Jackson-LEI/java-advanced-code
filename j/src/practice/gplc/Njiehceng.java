package practice.gplc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Njiehceng {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int x : arr) {
            HashSet<Integer> set = new HashSet<>();
            set.add(x);
            list.add(new HashSet<>(set));
            set.clear();
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        while (n > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).add(6)) {
                    temp.add(6);
                } else {
                    if (list.get(i).add(5)) {
                        temp.add(5);
                    } else {
                        if (list.get(i).add(4)) {
                            temp.add(4);
                        } else {
                            if (list.get(i).add(3)) {
                                temp.add(3);
                            } else {
                                if (list.get(i).add(2)) {
                                    temp.add(2);
                                } else {
                                    if (list.get(i).add(1)) {
                                        temp.add(1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ans.add(new ArrayList<>(temp));
            temp.clear();
            n--;
        }
        ans.forEach(System.out::println);
        for (int i = 0; i < ans.get(ans.size() - 1).size(); i++){
            if (i == ans.get(ans.size() - 1).size() - 1) {
                System.out.print(ans.get(ans.size() - 1).get(i));
            } else {
                System.out.print(ans.get(ans.size() - 1).get(i) + " ");
            }
        }
    }
}
