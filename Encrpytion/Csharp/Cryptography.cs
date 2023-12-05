using System;
using System.Security.Cryptography;
using System.Text;

namespace SystemCryptoExample;
class SystemCryptoExample
{
    static void Main()
    {
        // Generate an RSA key pair
        using (RSA rsa = RSA.Create())
        {
            // Original message
            string originalMessage = "Hello, .NET Crypto!";

            // Get the public and private keys
            RSAParameters publicKey = rsa.ExportParameters(false);
            RSAParameters privateKey = rsa.ExportParameters(true);

            // Encrypt the message using the public key
            byte[] encryptedMessage = EncryptWithPublicKey(originalMessage, publicKey);

            Console.WriteLine("Encrypted Message: " + BitConverter.ToString(encryptedMessage));

            // Decrypt the message using the private key
            string decryptedMessage = DecryptWithPrivateKey(encryptedMessage, privateKey);

            Console.WriteLine("Decrypted Message: " + decryptedMessage);
        }
    }

    static byte[] EncryptWithPublicKey(string plainText, RSAParameters publicKey)
    {
        using (RSA rsa = RSA.Create())
        {
            rsa.ImportParameters(publicKey);

            // Convert the message to bytes
            byte[] input = Encoding.UTF8.GetBytes(plainText);

            // Encrypt the message
            return rsa.Encrypt(input, RSAEncryptionPadding.Pkcs1);
        }
    }

    static string DecryptWithPrivateKey(byte[] encryptedMessage, RSAParameters privateKey)
    {
        using (RSA rsa = RSA.Create())
        {
            rsa.ImportParameters(privateKey);

            // Decrypt the message
            byte[] decrypted = rsa.Decrypt(encryptedMessage, RSAEncryptionPadding.Pkcs1);

            // Convert the decrypted bytes back to a string
            return Encoding.UTF8.GetString(decrypted);
        }
    }
}