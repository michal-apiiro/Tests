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
    public static void main(String[] args){
        String keysetFilePath = "path/to/jwt-keyset.json";
        KeysetHandle jwtKeysetHandle = KeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilePath)));

        // Create a JwtPublicKeySign for signing JWTs
        JwtPublicKeySign jwtSign = jwtKeysetHandle.getPrimitive(JwtPublicKeySign.class);

        // Example of signing a JWT
        String unsignedJwt = "{'sub':'1234567890','name':'John Doe','iat':1516239022}";
        String signedJwt = jwtSign.sign(unsignedJwt);
        System.out.println("Signed JWT: " + signedJwt);

        // Create a JwtPublicKeyVerify for verifying JWTs
        JwtPublicKeyVerify jwtVerify = jwtKeysetHandle.getPrimitive(JwtPublicKeyVerify.class);

        // Example of verifying a JWT
        try {
            jwtVerify.verify(signedJwt);
            System.out.println("JWT verification successful.");
        } catch (GeneralSecurityException e) {
            System.out.println("JWT verification failed: " + e.getMessage());
        }
    }
}
