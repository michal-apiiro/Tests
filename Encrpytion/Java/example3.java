package org.keyczar;

import com.google.gson.annotations.Expose;

import org.keyczar.enums.CipherMode;
import org.keyczar.exceptions.KeyczarException;
import org.keyczar.exceptions.ShortBufferException;
import org.keyczar.i18n.Messages;
import org.keyczar.interfaces.DecryptingStream;
import org.keyczar.interfaces.EncryptingStream;
import org.keyczar.interfaces.KeyType;
import org.keyczar.interfaces.SigningStream;
import org.keyczar.interfaces.Stream;
import org.keyczar.interfaces.VerifyingStream;
import org.keyczar.keyparams.AesKeyParameters;
import org.keyczar.util.Base64Coder;
import org.keyczar.util.Util;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class JavaEncryptionExample {
    public static void main(String[] args) throws Exception {
        CipherMode DEFAULT_MODE = CipherMode.CBC;
        VerifyingStream stream = VerifyingStream.stream;
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));
        System.out.println("Encrypted: " + new String(encryptedBytes));
    }
}
