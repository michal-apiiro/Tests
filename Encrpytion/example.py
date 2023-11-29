from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.primitives import hashes
from base64 import b64encode

def python_encryption_example():
    # Generate a key and IV
    key = b'secretkey1234567'
    iv = b'initialvector89'

    # Encryption
    cipher = Cipher(algorithms.AES(key), modes.CFB(iv), backend=default_backend())
    encryptor = cipher.encryptor()
    encrypted_bytes = encryptor.update(b'Hello, World!') + encryptor.finalize()
    print("Encrypted:", b64encode(encrypted_bytes).decode('utf-8'))

python_encryption_example()
