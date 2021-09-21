import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        key%=26;
        if (ch >= 'A' && ch <= (char) ('Z' - key) || ch >= 'a' && ch <= (char) ('z' - key))
            ch = (char) (ch + key);
        else if (ch >= (char) ('Z' - key + 1) && ch <= 'Z' || ch >= (char) ('z' - key + 1) && ch <= 'z')
            ch = (char) (ch - (26 - key));
        return ch;
    }

    public static char decryptCaesarLetter(char ch, int key) {
        key%=26;
        if (ch > (char) ('Z' - (26 - key)) && ch <= ('Z') || ch > (char) ('z' - (26 - key)) && ch <= 'z')
            ch = (char) (ch - key);
        else if (ch >= 'A' && ch <= (char) ('A' + key) || ch >= 'a' && ch <= (char) ('a' + key))
            ch = (char) (ch + (26 - key));
        return ch;
    }
    public static String encryptVigenere(String message, String key) {
        int count = 0;
        String encrypted = "";
        for(int i = 0;i<message.length();i++){
            if (message.charAt(i)>='A'&&message.charAt(i)<='Z'||message.charAt(i)>='a'&&message.charAt(i)<='z') {
                encrypted += encryptCaesarLetter(message.charAt(i), key.toLowerCase().charAt(count)-'a');
                count++;
            }
            else encrypted+=message.charAt(i);
            if (count==key.length())
                count = 0;
        }
        return encrypted;
    }

    public static String decryptVigenere(String message, String key) {
        int count = 0;
        String decrypted = "";
        for(int i = 0;i<message.length();i++){
            if (message.charAt(i)>='A'&&message.charAt(i)<='Z'||message.charAt(i)>='a'&&message.charAt(i)<='z') {
                decrypted += decryptCaesarLetter(message.charAt(i), key.toLowerCase().charAt(count)-'a');
                count++;
            }
            else decrypted+=message.charAt(i);
            if (count==key.length())
                count = 0;
        }
        return decrypted;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
        System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
        System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
        System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
        System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
        System.out.println();
        System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
        System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
        System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
        System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
        System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
