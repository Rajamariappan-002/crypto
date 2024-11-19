import java.util.Scanner;

public class viginere{

    public static String encrypt(String text, String key){

        StringBuilder cipher = new StringBuilder();
        int keywordindex = 0;

        for(char ch : text.toCharArray()){
            if(Character.isLetter(ch)){

                char shift = Character.toUpperCase(key.charAt(keywordindex % key.length()));
                int shiftvalue = shift - 'A';

                char encryptedchar = Character.isUpperCase(ch) ? (char)('A' + (ch - 'A' + shiftvalue) % 26)
                                                                : (char)('a' + (ch - 'a' + shiftvalue) % 26);

                cipher.append(encryptedchar);

            }else{
                cipher.append(ch);
            }
         keywordindex++;
            
        }

        System.out.println(cipher.toString());

        return cipher.toString();
    }

    public static void decrypt(String text, String key){

        StringBuilder cipher = new StringBuilder();
        int keywordindex = 0;

        for(char ch : text.toCharArray()){
            if(Character.isLetter(ch)){

                char shift = Character.toUpperCase(key.charAt(keywordindex % key.length()));
                int shiftvalue = shift - 'A';

                char encryptedchar = Character.isUpperCase(ch) ? (char)('A' + (ch - 'A' -  shiftvalue + 26) % 26)
                                                                : (char)('a' + (ch - 'a' -  shiftvalue + 26) % 26);

                cipher.append(encryptedchar);

            }else{
                cipher.append(ch);
            }
         keywordindex++;
            
        }

        System.out.println(cipher.toString());
    }


    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine();

        System.out.println("Enter a key String:");
        String key  = scanner.nextLine();

        String cipher = encrypt(text, key);
        decrypt(cipher, key);
    }
}