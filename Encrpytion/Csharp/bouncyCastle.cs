using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Generators;
using Org.BouncyCastle.Crypto.Parameters;
using Org.BouncyCastle.Security;


namespace BouncyCastle;
public class ECKeyPairGenerationExample
{
    public static AsymmetricCipherKeyPair GenerateECKeyPair()
    {
        // Assume you have EC domain parameters already set up (not shown here)
        ECDomainParameters ecDomainParameters = new ECDomainParameters(/* ... */);

        var keyGenerationParameters = new ECKeyGenerationParameters(ecDomainParameters, new SecureRandom());
        var keyPairGenerator = GeneratorUtilities.GetKeyPairGenerator("EC");
        keyPairGenerator.Init(keyGenerationParameters);

        return keyPairGenerator.GenerateKeyPair();
    }
}
