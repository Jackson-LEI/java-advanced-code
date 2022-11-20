package practice;

import java.util.Scanner;

public class AICoreCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            String origin = sc.nextLine();
            String s = origin.trim().replace('?', '!');
            StringBuilder sb1 = new StringBuilder(s);
            for (int i = 0; i < sb1.length(); i++) {
                if (i > 0 && !Character.isAlphabetic(sb1.charAt(i)) && sb1.charAt(i) != ' ') {
                    if (sb1.charAt(i - 1) == ' ') {
                        sb1.deleteCharAt(i - 1);
                    }
                }
            }
            String[] temp = new String(sb1).split(" +");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].equals(" ")) {
                    temp[i] = "";
                }
                if (i == temp.length - 1) {
                    sb.append(temp[i]);
                } else {
                    sb.append(temp[i]).append(" ");
                }
            }

            while (true) {
                if (s.contains("I")) {
                    if (!Character.isAlphabetic(s.indexOf("I") + 1) && !Character.isAlphabetic(s.indexOf("I") - 1)) {
                        sb.replace(s.indexOf("I"), s.indexOf("I"), "you");
                        s.replace(sb1, sb);
                    } else {
                        break;
                    }
                } else if (s.contains("me")) {
                    if (!Character.isAlphabetic(s.indexOf("me") + 2) && !Character.isAlphabetic(s.indexOf("me") - 1)) {
                        sb.replace(s.indexOf("me"), s.indexOf("me") + 2, "you");
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            while (true) {
                if (s.contains("can")) {
                    int index = s.indexOf("can");
                    if (!Character.isAlphabetic(s.charAt(index + 3)) && s.length() >= index + 7) {
                        if (s.substring(index + 4, index + 7).equals("you")) {
                            sb.replace(index, index + 7, "I can1");
                            s.replace("can you", "I can1");
                        }
                    }
                } else if (s.contains("could")) {
                    int index = s.indexOf("could");
                    if (!Character.isAlphabetic(s.charAt(index + 5)) && s.length() >= index + 9) {
                        if (s.substring(index + 6, index + 9).equals("you")) {
                            sb.replace(index, index + 9, "I could");
                            s.replace("could you", "I could");
                        }
                    }
                } else {
                    break;
                }
            }
            System.out.println(origin);
            System.out.print("AI: " + sb);
            n--;
        }
        sc.close();
    }
}
