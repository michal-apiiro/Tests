package com.ulisesbocchio.jasyptspringboot.encryptor;

import com.ulisesbocchio.jasyptspringboot.util.Singleton;
import lombok.SneakyThrows;
import org.jasypt.encryption.ByteEncryptor;
import org.jasypt.iv.IvGenerator;
import org.jasypt.salt.SaltGenerator;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;

public class JavaEncryptionExample {
    public static void main(String[] args) throws Exception {
       SecretKey secretKey =  SecretKeySpec(secretKeyBytes, "AES");
    }
}

