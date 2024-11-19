import java.util.Scanner;

public class Substitution{

   

    static void encrypt(String text, int key){
        StringBuilder enc = new StringBuilder();
        StringBuilder dec = new StringBuilder();
        key = key % 26;

        for(char c: text.toCharArray()){
            if(Character.isUpperCase(c)){
                enc.append((char) ('A'+ (c-'A' + key) % 26) );
            }else if(Character.isLowerCase(c)){
                enc.append((char)('a' + (c-'a' + key) % 26) );
            }else{
                enc.append(c);
            }
        }

        System.out.println(enc.toString());
        String encr = enc.toString();

        for(char c: encr.toCharArray()){
            if(Character.isUpperCase(c)){
                dec.append((char) ('A'+ (c-'A' - key ) % 26) );
            }else if(Character.isLowerCase(c)){
                dec.append((char)('a' + (c-'a' - key ) % 26) );
            }else{
                dec.append(c);
            }
        }

        
        System.out.println(dec.toString());
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine();

        System.out.println("Enter a key value:");
        int key  = scanner.nextInt();

        encrypt(text, key);

    }
}