package java;

import org.keyczar.enums.CipherMode;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.Crypter;


public class JavaEncryptionExample {
    public static void main(String[] args) {
        Crypter crypter = new Crypter(keysetPath);
        CipherMode encryptMode = CipherMode.ENCRYPT;
        CipherMode decryptMode = CipherMode.DECRYPT;
    }
}
