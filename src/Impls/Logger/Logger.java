package Impls.Logger;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private static Logger logger;
    private final String logfile = "log.txt";
    private PrintWriter writer;

    private Logger() {
        try {
            FileWriter fw = new FileWriter(logfile);
            writer = new PrintWriter(fw, true);
        } catch (IOException e) {

        }
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public synchronized void writeToLogger(String operationName, Date date, String username) {
        writer.println("Operation :" + operationName + ",Date & Time: " + date +
                ",Username: " + username);
    }
}
