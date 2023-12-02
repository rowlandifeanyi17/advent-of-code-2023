package adventOfCode2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFiles {

    public List<String> getFiles(String path) {
        List<String> lines = new ArrayList<>();
        try {

            Scanner scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }

}