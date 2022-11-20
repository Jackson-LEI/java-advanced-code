package practice;

import java.util.Scanner;

public class LetterString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n>0){
            String s = sc.next();
            boolean isOK = true;
            for(int i=0;i<s.length()-1;i++){
                if(Character.isUpperCase(s.charAt(i))){
                    String temp = String.valueOf(s.charAt(i)).toLowerCase();
                    char upper;
                    if(s.charAt(i)=='z'){
                        upper = 'a';
                    }else if(s.charAt(i)=='Z') {
                        upper = 'A';
                    }else{
                        upper = (char) (s.charAt(i) +1);
                    }
//                    System.out.print(temp + " ");
//                    System.out.print(upper);
                    if(s.charAt(i+1)==temp.charAt(0) || s.charAt(i+1)==upper){
                        isOK = true;
                    }else{
                        isOK = false;
                        break;
                    }
                }else{
                    String temp = String.valueOf(s.charAt(i)).toUpperCase();
                    char lower;
                    if(s.charAt(i)=='a'){
                        lower = 'z';
                    }else if(s.charAt(i)=='A') {
                        lower = 'Z';
                    }else{
                        lower = (char) (s.charAt(i) - 1);
                    }
//                    System.out.print(temp + " ");
//                    System.out.print(lower + " ");
                    if(s.charAt(i+1)==temp.charAt(0) || s.charAt(i+1)==lower){
                        isOK = true;
                    }else{
                        isOK = false;
                        break;
                    }
                }
            }
            if(isOK){
                System.out.println("Y");
            }else{
                System.out.println("N");
            }
            n--;
        }
        sc.close();
    }
}
