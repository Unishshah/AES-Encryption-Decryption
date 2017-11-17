import java.util.Arrays; // converting arrays to string
import javax.crypto.Cipher; // Functionality of a cryptographic cipher for encryption and decryption.(Here AES)
import javax.crypto.KeyGenerator; //Functionality of a secret (symmetric) key generator.
import javax.crypto.SecretKey; // To provide a  secret (symmetric) key.


public class AESEncryption {


    public static void main(String[] args) throws Exception { // main method

        String plainText = "ProgrammingAssignment4"; // Given string

        SecretKey secKey = getSecretEncryptionKey(); // generates encryption key

        byte[] cipherText = encryptText(plainText, secKey); // calls the encryption method

        String decryptedText = decryptText(cipherText, secKey); // calls the decryption method

         

        System.out.println("Original Text:" + plainText); // prints the plaintext

        System.out.println("AES Key:"+Arrays.toString(secKey.getEncoded())); // prints the secret key

        System.out.println("Encrypted Text:"+Arrays.toString(cipherText)); // prints the encryption text

        System.out.println("Descrypted Text:"+decryptedText);// prints the decryption text

         

    }

     


    public static SecretKey getSecretEncryptionKey() throws Exception{ // generates a random secret key

        KeyGenerator generator = KeyGenerator.getInstance("AES"); // Specific key generator for AES Algorithm

        generator.init(128); // I have taken 128 bits AES key size

        SecretKey secKey = generator.generateKey(); // Generates the Secret key

        return secKey; // Returns the generated AES key

    }

     

    
    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{ //Encrypts plainText in AES using the secret key

        Cipher aesCipher = Cipher.getInstance("AES"); // AES defaults to PKCS5Padding in Java 8.2

        aesCipher.init(Cipher.ENCRYPT_MODE, secKey); // By default ECB encryption mode is selected

        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes()); // used for conclusion of operation and converts the encrypted string to bytes

        return byteCipherText; // returns the encrypted string

    }

     


    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception { //Decrypts plainText in AES using the secret key

        Cipher aesCipher = Cipher.getInstance("AES"); //AES defaults to PKCS5Padding in Java 8.2

        aesCipher.init(Cipher.DECRYPT_MODE, secKey); // By default ECB decryption mode is selected

        byte[] bytePlainText = aesCipher.doFinal(byteCipherText); // converts encryption string to plaintext again

        return new String(bytePlainText); // returns the decrypted plaintext in string format

    }

}
