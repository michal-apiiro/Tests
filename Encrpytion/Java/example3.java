package java;

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


public class JavaEncryptionExample {
    public static void main(String[] args) {
        CipherMode encryptMode = CipherMode.ENCRYPT;
        CipherMode decryptMode = CipherMode.DECRYPT;
    }
}
