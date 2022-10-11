package shivammishr17.pattern.to.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    public File openFile(String fileName) {
        LOGGER.info("Opening file {}", fileName);
        return new File(fileName);
    }

    public void writeToFile(File file, String data) {
        LOGGER.info("Writing data to file.");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true), 10000)){
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
