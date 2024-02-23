package View;

import Model.ReadFile;

public class Main {

    public static void main(String[] args) {
        ReadFile reader = new ReadFile();
        try {
            reader.readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
