package Java;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;

public class JavaEncryptionExample {
    public static void main(String[] args) throws Exception {
        jnlpMac = JnlpSlaveAgentProtocol.SLAVE_SECRET.mac(slaveName.getBytes("UTF-8"));
        SecretKey key = new SecretKeySpec(jnlpMac, 0, /* export restrictions */ 128 / 8, "AES");
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecretKey secretKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));
    }
}
