package practice.start;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@SuppressWarnings("ALL")
public class GetRandomNumber {

    public static void main(String[] args) throws IOException {
        Random r = new Random();
        int[] l = new int[50];
        for (int i = 0; i < l.length; i++) {
            l[i] = r.nextInt(500000);
        }

        java.util.Arrays.sort(l);

        File file = new File("D://out.txt");
        FileWriter fos = new FileWriter(file, true);
        for (int i = 0; i < l.length; i++) {
            fos.write(l[i] + "\t");
        }

        fos.close();
        System.out.print("Finished!");
    }

}
