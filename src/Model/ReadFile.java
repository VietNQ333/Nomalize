package Model;

import Controller.TextManager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadFile {


    BufferedReader br = null;

    public void readFile() {
        try {
            br = new BufferedReader(new FileReader(new File("test.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                if (TextManager.isLineEmpty(line)) {
                    continue;
                }
                line = TextManager.formatOneSpace(line);
                line = TextManager.formatSpecialCharacters(line);
                line = TextManager.afterDotUpperCase(line);
                line = TextManager.noSpaceQuotes(line);
                line = TextManager.firstUppercase(line);
                line = TextManager.lastAddDot(line);
                line = TextManager.noSpaceBeforeCommaDot(line);
                if (isFirstLine) {
                    line = TextManager.firstUppercase(line);
                    isFirstLine = false;
                }

                pw.print(line);
                pw.print(System.getProperty("line.separator"));
            }

            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            pw.close();
            System.out.println("Normalize successful.");

        } catch (FileNotFoundException ex) {
            System.err.println("File not found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
