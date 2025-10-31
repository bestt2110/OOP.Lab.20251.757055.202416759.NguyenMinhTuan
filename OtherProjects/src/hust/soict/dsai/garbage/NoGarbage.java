package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "src/hust/soict/dsai/garbage/test.txt"; 
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));

        long startTime = System.currentTimeMillis();

        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
