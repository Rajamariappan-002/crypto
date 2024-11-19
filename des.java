import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class des{

    public static String encrypt(String text, SecretKey sec)throws Exception{
        Cipher cip = Cipher.getInstance("DES");
        cip.init(Cipher.ENCRYPT_MODE,sec);

        byte cipher[] =  cip.doFinal(text.getBytes());



        return Base64.getEncoder().encodeToString(cipher);
    }

    public static String decrypt(String text, SecretKey sec)throws Exception{
        Cipher cip = Cipher.getInstance("DES");

        cip.init(Cipher.DECRYPT_MODE, sec);

        byte origin[] = cip.doFinal(Base64.getDecoder().decode(text));

        return new String(origin);
    }


    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

            KeyGenerator k = KeyGenerator.getInstance("DES");
            k.init(56);

            SecretKey sec = k.generateKey();

            System.out.println("Enter the text to encrypt:");
            String text = scanner.nextLine();


            String encrypted = encrypt(text, sec);
            System.out.println(encrypted);

            System.out.println("Decrypted:"+decrypt(encrypted,sec));



        }catch(Exception e){

        }
    }

}