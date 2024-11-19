import java.util.Scanner;
import java.math.BigInteger;

public class RSA {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1st prime number:");
        BigInteger p = scanner.nextBigInteger();

        System.out.println("Enter 2nd prime number:");
        BigInteger q = scanner.nextBigInteger();

        BigInteger n =p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        System.out.println("Enter a value for e:(1<e<phi) e must be co prime to phi");
        BigInteger e = scanner.nextBigInteger();

        while(e.gcd(phi).compareTo(BigInteger.ONE) != 0){
            System.out.println("Invalid value for e, enter another value.");
            e = scanner.nextBigInteger();
        }

        BigInteger d = e.modInverse(phi);

        System.out.println("Enter a message to encrypt:");
        BigInteger msg = scanner.nextBigInteger();

        BigInteger cipher = msg.modPow(e,n);
        System.out.println("Genrated cipher:"+ cipher);

        BigInteger decrypted = cipher.modPow(d, n);
        System.out.println(decrypted);

        if(msg.equals(decrypted)){
            System.out.println("Decryption is successful");
        }


        

    }
}
