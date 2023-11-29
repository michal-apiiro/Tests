/**
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
// [START java-jwt-sign-example]
package jwt;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.TinkJsonProtoKeysetFormat;
import com.google.crypto.tink.jwt.JwtPublicKeySign;
import com.google.crypto.tink.jwt.JwtSignatureConfig;
import com.google.crypto.tink.jwt.RawJwt;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;


public class JavaEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate a secret key
        KeysetHandle cipherParameters = KeysetHandle.getInstance("AES");
        AEADBlockCipher secretKey = AEADBlockCipher.generateKey();
        
        // Encryption
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal("Hello, World!".getBytes(StandardCharsets.UTF_8));
        System.out.println("Encrypted: " + new String(encryptedBytes));
    }
}
