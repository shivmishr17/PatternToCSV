package shivammishr17.pattern.to.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PatternService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatternService.class);
    public String createPattern(String item, int start, int end, int itemsPerLine) {
        LOGGER.info("Creating pattern");
        StringBuilder builder = new StringBuilder();
        int itemCounter = 0;
        for (int i = start; i <= end; i++, itemCounter++) {
            if (itemCounter == itemsPerLine) {
                itemCounter = 0;
                builder.append("\n");
            }
            builder.append(item);
            builder.append(',');
            builder.append(i);
            builder.append(',');
        }
        return builder.toString();
    }
}
