import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        String filePath = "data.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {

                try {
                    int number = Integer.parseInt(line);
                    if (number < 100) {
                        throw new LessThanException("Error");
                    } else {
                        logger.info("number is " + number);
                    }
                } catch (NumberFormatException e) {
                    logger.warning("Invalid Input");
                } catch (LessThanException e) {
                    logger.warning("number is less than 100 " + e);
                }

            }
        } catch (IOException e) {
            logger.warning("Issue with acessing file : " + e);
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                logger.warning("Closing isn't possible because of file issue : " + e);
            } finally {
                logger.info("Execution Done");
            }

        }

    }
}
