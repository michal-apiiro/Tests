package org.cryptacular.adapter;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.cryptacular.CryptoException;


public class JavaEncryptionExample {
    public static void main(String[] args) {
        byte[] keyBytes = new byte[16];
        byte[] ivBytes = new byte[12];

        SecureRandom random = new SecureRandom();
        random.nextBytes(keyBytes);
        random.nextBytes(ivBytes);

        // Create an AEAD block cipher (e.g., GCM mode)
        AEADBlockCipher cipher = new AEADBlockCipher();

        // Initialize the cipher with the key and IV
        CipherParameters parameters = new CipherParameters(new KeyParameter(keyBytes), ivBytes);
        cipher.init(true, parameters);  // 'true' for encryption, 'false' for decryption

        // Example of encrypting a message
        byte[] plaintext = "Hello, World!".getBytes();
        byte[] ciphertext = new byte[cipher.getOutputSize(plaintext.length)];

        int len = cipher.processBytes(plaintext, 0, plaintext.length, ciphertext, 0);
        len += cipher.doFinal(ciphertext, len);

        System.out.println("Ciphertext: " + new String(ciphertext));

        // Example of decrypting the message
        cipher.init(false, parameters);  // Re-initialize for decryption
        byte[] decryptedBytes = new byte[cipher.getOutputSize(ciphertext.length)];

        len = cipher.processBytes(ciphertext, 0, ciphertext.length, decryptedBytes, 0);
        len += cipher.doFinal(decryptedBytes, len);

        System.out.println("Decrypted: " + new String(decryptedBytes));

    }
}