package java;

import org.cryptacular.util.StreamUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StreamUtilExample {

    public static void main(String[] args) {
        // Example data as a byte array
        byte[] inputData = "Hello, StreamUtil!".getBytes();

        // Using ByteArrayInputStream to represent an input stream
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);

        // Using ByteArrayOutputStream to represent an output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            // Using StreamUtil to copy data from input stream to output stream
            StreamUtil.copy(inputStream, outputStream);

            // Convert the result to a byte array
            byte[] outputData = outputStream.toByteArray();

            // Print the original and copied data as strings
            System.out.println("Original Data: " + new String(inputData));
            System.out.println("Copied Data: " + new String(outputData));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the streams to release resources
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
