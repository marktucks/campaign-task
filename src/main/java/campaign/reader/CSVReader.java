package campaign.reader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        Resource resource = new ClassPathResource("static/"+file);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

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
