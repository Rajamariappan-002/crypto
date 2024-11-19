import java.math.BigInteger;
import java.util.Scanner;
public class Diffie{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a prime number:");
        BigInteger p = scanner.nextBigInteger();
    
        System.out.println("Enter a base:");
        BigInteger g = scanner.nextBigInteger();

        System.out.println("Enter A's private key:");
        BigInteger PrivateKeyA = scanner.nextBigInteger();

        
        System.out.println("Enter B's private key:");
        BigInteger PrivateKeyB = scanner.nextBigInteger();

        System.out.println("Calculating public key A");

        BigInteger publicKeyA = g.modPow(PrivateKeyA, p);



        System.out.println("Calculating public key B");
        BigInteger publicKeyB = g.modPow(PrivateKeyB, p);


        BigInteger sharedA = publicKeyB.modPow(PrivateKeyA,p);
        BigInteger sharedB = publicKeyA.modPow(PrivateKeyB,p);

        if(sharedA.equals(sharedB)){
            System.out.println("Secret key matched...sucess..");
        }else{
            System.out.println("Failed to generate the secret key");
        }

    }
}