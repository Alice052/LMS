package log;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    private PrintWriter writer;


    public Logger(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.out.println("Could not initialize logger");
        }
    }

    public void log(String message) {
        if (writer != null) {
            writer.println(message);

//            writer.printf(
//     "%-6d %-20s %-18s %-20s%n",
//     b.getBookid(),
//     b.getBookName(),
//     b.getAuthor(),
//     b.getGenre()
// );


            writer.flush();
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
