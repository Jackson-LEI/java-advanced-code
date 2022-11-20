package finalExamination;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class DifElse {

    public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int waterTemp = sc.nextInt();
//		switch (waterTemp) {
//		case 10: System.out.println("water is cold.");
//		break;
//		case 30: System.out.println("water is warm.");
//		break;
//		case 50: System.out.println("water is hot.");
//		break;
//		}
//		sc.close();

        Scanner sc1 = new Scanner(System.in);
        int waterTemp1 = sc1.nextInt();
        if (waterTemp1 == 10) {
            System.out.println("water is cold.");
        }
        if (waterTemp1 == 30) {
            System.out.println("water is warm.");
        }
        if (waterTemp1 == 50) {
            System.out.println("water is hot.");
        }
        sc1.close();
    }

}