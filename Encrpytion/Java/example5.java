package org.cryptacular.adapter;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.cryptacular.CryptoException;


public class JavaEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate a secret key
        CipherParameters cipherParameters = CipherParameters.getInstance("AES");
        AEADBlockCipher secretKey = AEADBlockCipher.generateKey();
        
        // Encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));
        System.out.println("Encrypted: " + new String(encryptedBytes));
    }
}
