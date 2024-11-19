import java.util.Scanner;

public class RailFence{

    static void encrypt(String text, int key){
        
        StringBuilder[] rails = new StringBuilder[key];

        for(int i = 0; i<key; i++ ){
            rails[i] = new StringBuilder();
        }

        int direction = 1;
        int rail = 0;

        for(char ch: text.toCharArray()){
            rails[rail].append(ch);

            if(rail == 0){
                direction = 1;

            }else if(rail == key -1){
                direction = -1;
            }
            rail += direction;
        }

        StringBuilder encrypted = new StringBuilder();
        for(StringBuilder sb : rails){
            encrypted.append(sb);
        }
        System.out.println(encrypted.toString());

        }


    


    public static void main(String[]args){
         Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = scanner.nextLine();

        System.out.println("Enter a key value:");
        int key  = scanner.nextInt();

        encrypt(text, key);
        scanner.close();

    }
}