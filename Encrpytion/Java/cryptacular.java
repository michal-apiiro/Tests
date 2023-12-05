package java;
import org.cryptacular.spec.DigestSpec;
import org.cryptacular.util.StreamUtil;
import org.cryptacular.util.HashUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CryptacularExample {

    public static void main(String[] args) {
        try {
            // Example data as a byte array
            byte[] inputData = "Hello, Cryptacular!".getBytes();

            // Using ByteArrayInputStream to represent an input stream
            ByteArrayInputStream inputStream = new ByteArrayInputStream(inputData);

            // Using StreamUtil to read the input stream and generate a hash
            byte[] hash = generateHash(inputStream, "SHA-256");

            // Print the original data and the generated hash
            System.out.println("Original Data: " + new String(inputData));
            System.out.println("Generated Hash: " + bytesToHex(hash));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] generateHash(ByteArrayInputStream inputStream, String algorithm) throws IOException {
        try {
            // Create a DigestSpec with the specified algorithm
            DigestSpec digestSpec = new DigestSpec(algorithm);

            // Generate the hash using StreamUtil and HashUtil
            return HashUtil.getHash(StreamUtil.readAll(inputStream), digestSpec);
        } finally {
            // Close the input stream to release resources
            inputStream.close();
        }
    }

    // Utility method to convert a byte array to a hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexStringBuilder = new StringBuilder(2 * bytes.length);
        for (byte b : bytes) {
            hexStringBuilder.append(String.format("%02x", b & 0xff));
        }
        return hexStringBuilder.toString();
    }
}
