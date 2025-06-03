import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {

    public static void writeOutput(
        String plaintext, String plaintextDash,
        String key, String keyDash,
        String ciphertext1, String ciphertext2,
        int[][] bitDiffsP, int[][] bitDiffsK,
        double elapsedSeconds
    ) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println("Avalanche Demonstration");
            writer.println("Plaintext P: " + plaintext);
            writer.println("Plaintext P’: " + plaintextDash);
            writer.println("Key K: " + key);
            writer.println("Key K’: " + keyDash);
            writer.printf("Total running time: %.3f seconds\n\n", elapsedSeconds);

            // P and P’ under same key
            writer.println("P and P’ under K");
            writer.println("Ciphertext C: " + ciphertext1);
            writer.println("Ciphertext C’: " + ciphertext2);
            writer.println();
            writer.println("Round    DES0  DES1  DES2  DES3");
            for (int i = 0; i <= 16; i++) {
                writer.printf("%-9d%-6d%-6d%-6d%-6d\n", i,
                    bitDiffsP[i][0], bitDiffsP[i][1], bitDiffsP[i][2], bitDiffsP[i][3]);
            }

            // P under K and K’
            writer.println();
            writer.println("P under K and K’");
            writer.println("Ciphertext C: " + ciphertext1);
            writer.println("Ciphertext C’: " + ciphertext2);
            writer.println();
            writer.println("Round    DES0  DES1  DES2  DES3");
            for (int i = 0; i <= 16; i++) {
                writer.printf("%-9d%-6d%-6d%-6d%-6d\n", i,
                    bitDiffsK[i][0], bitDiffsK[i][1], bitDiffsK[i][2], bitDiffsK[i][3]);
            }

            System.out.println("Output written to output.txt");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
