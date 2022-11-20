package practice.gplc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int forb = sc.nextInt();
        int peitong = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if (a > forb) {
            if (a >= peitong) {
                if (b > forb) {
                    System.out.println(a + "-Y " + b + "-Y");
                    System.out.println("huan ying ru guan");
                } else {
                    System.out.println(a + "-Y " + b + "-Y");
                    System.out.println("qing " + 1 + " zhao gu hao " + 2);
                }
            } else {
                if (b > forb) {
                    System.out.println(a + "-Y " + b + "-Y");
                    System.out.println("huan ying ru guan");
                } else {
                    System.out.println(a + "-Y " + b + "-N");
                    System.out.println(1 + ": huan ying ru guan");
                }
            }
        } else {
            if (b > forb) {
                if (b >= peitong) {
                    System.out.println(a + "-Y " + b + "-Y");
                    System.out.println("qing " + 2 + " zhao gu hao " + 1);
                } else {
                    System.out.println(a + "-N " + b + "-Y");
                    System.out.println(2 + ": huan ying ru guan");
                }
            }else{
                System.out.println("zhang da zai lai ba");
            }
        }
    }
}