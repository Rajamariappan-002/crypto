import java.util.Scanner;

public class PlayfairCipher {

    private static char[][] generateKeyMatrix(String key) {
        char[][] matrix = new char[5][5];
        boolean[] used = new boolean[26];
        used['J' - 'A'] = true; // Treat 'I' and 'J' as the same letter

        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        int index = 0;

        // Fill the key in the matrix
        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[index / 5][index % 5] = c;
                used[c - 'A'] = true;
                index++;
            }
        }

        // Fill the rest of the matrix
        for (char c = 'A'; c <= 'Z'; c++) {
            if (!used[c - 'A']) {
                matrix[index / 5][index % 5] = c;
                index++;
            }
        }

        return matrix;
    }

    private static String preprocess(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace('J', 'I');
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                builder.append(text.charAt(i)).append('X');
            } else {
                builder.append(text.charAt(i));
            }
        }

        if (builder.length() % 2 != 0) {
            builder.append('X');
        }

        return builder.toString();
    }

    private static String processText(String text, char[][] matrix, boolean encrypt) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int[] posA = findPosition(a, matrix);
            int[] posB = findPosition(b, matrix);

            if (posA[0] == posB[0]) { // Same row
                result.append(matrix[posA[0]][(posA[1] + (encrypt ? 1 : 4)) % 5])
                      .append(matrix[posB[0]][(posB[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (posA[1] == posB[1]) { // Same column
                result.append(matrix[(posA[0] + (encrypt ? 1 : 4)) % 5][posA[1]])
                      .append(matrix[(posB[0] + (encrypt ? 1 : 4)) % 5][posB[1]]);
            } else { // Rectangle
                result.append(matrix[posA[0]][posB[1]])
                      .append(matrix[posB[0]][posA[1]]);
            }
        }

        return result.toString();
    }

    private static int[] findPosition(char c, char[][] matrix) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (matrix[row][col] == c) {
                    return new int[]{row, col};
                }
            }
        }
        return null; // Should never happen
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the key: ");
        String key = scanner.nextLine();

        System.out.print("Enter the plaintext: ");
        String plaintext = scanner.nextLine();

        char[][] keyMatrix = generateKeyMatrix(key);
        String preparedText = preprocess(plaintext);
        String encryptedText = processText(preparedText, keyMatrix, true);

        System.out.println("Encrypted text: " + encryptedText);

        String decryptedText = processText(encryptedText, keyMatrix, false);
        System.out.println("Decrypted text: " + decryptedText);

        scanner.close();
    }
}
