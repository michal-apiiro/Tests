package java;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JasyptExample {

    public static void main(String[] args) {
        try {
            // Load properties from a file
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("application.properties");
            properties.load(fis);

            // Create a StringEncryptor
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword("yourEncryptionPassword");

            // Wrap the properties with EncryptableProperties using the encryptor
            EncryptableProperties encryptableProperties = new EncryptableProperties(encryptor);
            encryptableProperties.putAll(properties);

            // Access the properties as you normally would
            String value = encryptableProperties.getProperty("yourPropertyKey");
            System.out.println("Decrypted Value: " + value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
