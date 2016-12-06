package campaign.reader;

import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVReader {

    private static final Logger LOGGER = Logger.getLogger("CSVReader");

    private static final String DELIMITER = "\\s*,\\s*";

    public static List<String[]> read(String file) {
        String line = "";
        List<String[]> strings = new LinkedList<>();

        ClassPathResource cpr = new ClassPathResource("static/"+file);

        try (BufferedReader br = new BufferedReader(new FileReader(cpr.getFile()))) {

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(DELIMITER);
                strings.add(tokens);
            }

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Cannot process file "+file, e);
        }

        Collections.reverse(strings);
        return strings;
    }
}
