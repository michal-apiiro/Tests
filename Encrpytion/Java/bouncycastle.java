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

    }
}