package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "src/resources/log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void logTicketOperation(String ticketId, String operationType) {
        String timeStampedMessage = String.format(
                "[%s] Operation: %s, Ticket ID: %s",
                LocalDateTime.now().format(FORMATTER),
                operationType,
                ticketId
        );
        log(timeStampedMessage);
    }

    private static void log(String message) {
        System.out.println(message);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
